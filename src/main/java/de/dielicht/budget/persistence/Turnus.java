package de.dielicht.budget.persistence;

import java.time.Month;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Turnus {
	monthly {
		@Override
		public List<MonthDay> createTurnusPoints() {
			return Arrays.stream(Month.values()).collect(Collectors.mapping(month -> MonthDay.of(month, 1),
					Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)));
		}
	},
	quarterly {
		@Override
		public List<MonthDay> createTurnusPoints() {
			return Collections.unmodifiableList(Arrays.asList(MonthDay.of(Month.JANUARY, 1),
					MonthDay.of(Month.APRIL, 1), MonthDay.of(Month.JUNE, 1), MonthDay.of(Month.OCTOBER, 1)));
		}
	},
	halfYearly {
		@Override
		public List<MonthDay> createTurnusPoints() {
			return Collections
					.unmodifiableList(Arrays.asList(MonthDay.of(Month.JANUARY, 1), MonthDay.of(Month.JUNE, 1)));
		}
	},
	annual {
		@Override
		public List<MonthDay> createTurnusPoints() {
			return Collections.singletonList(MonthDay.of(Month.JANUARY, 1));
		}
	};

	abstract public List<MonthDay> createTurnusPoints();
}
