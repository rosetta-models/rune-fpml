package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.DayOfWeekEnum;
import fpml.confirmation.DaysModelSequence1;
import fpml.confirmation.DaysModelSequence1.DaysModelSequence1Builder;
import fpml.confirmation.DaysModelSequence1.DaysModelSequence1BuilderImpl;
import fpml.confirmation.DaysModelSequence1.DaysModelSequence1Impl;
import fpml.confirmation.meta.DaysModelSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DaysModelSequence1", builder=DaysModelSequence1.DaysModelSequence1BuilderImpl.class, version="${project.version}")
public interface DaysModelSequence1 extends RosettaModelObject {

	DaysModelSequence1Meta metaData = new DaysModelSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The day(s) of the week on which pricing will take place during the pricing period.
	 */
	List<DayOfWeekEnum> getDayOfWeek();
	/**
	 * The occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
	 */
	Integer getDayNumber();

	/*********************** Build Methods  ***********************/
	DaysModelSequence1 build();
	
	DaysModelSequence1.DaysModelSequence1Builder toBuilder();
	
	static DaysModelSequence1.DaysModelSequence1Builder builder() {
		return new DaysModelSequence1.DaysModelSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DaysModelSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DaysModelSequence1> getType() {
		return DaysModelSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
		processor.processBasic(path.newSubPath("dayNumber"), Integer.class, getDayNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DaysModelSequence1Builder extends DaysModelSequence1, RosettaModelObjectBuilder {
		DaysModelSequence1.DaysModelSequence1Builder addDayOfWeek(DayOfWeekEnum dayOfWeek0);
		DaysModelSequence1.DaysModelSequence1Builder addDayOfWeek(DayOfWeekEnum dayOfWeek1, int _idx);
		DaysModelSequence1.DaysModelSequence1Builder addDayOfWeek(List<DayOfWeekEnum> dayOfWeek2);
		DaysModelSequence1.DaysModelSequence1Builder setDayOfWeek(List<DayOfWeekEnum> dayOfWeek3);
		DaysModelSequence1.DaysModelSequence1Builder setDayNumber(Integer dayNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dayOfWeek"), DayOfWeekEnum.class, getDayOfWeek(), this);
			processor.processBasic(path.newSubPath("dayNumber"), Integer.class, getDayNumber(), this);
		}
		

		DaysModelSequence1.DaysModelSequence1Builder prune();
	}

	/*********************** Immutable Implementation of DaysModelSequence1  ***********************/
	class DaysModelSequence1Impl implements DaysModelSequence1 {
		private final List<DayOfWeekEnum> dayOfWeek;
		private final Integer dayNumber;
		
		protected DaysModelSequence1Impl(DaysModelSequence1.DaysModelSequence1Builder builder) {
			this.dayOfWeek = ofNullable(builder.getDayOfWeek()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.dayNumber = builder.getDayNumber();
		}
		
		@Override
		@RosettaAttribute("dayOfWeek")
		public List<DayOfWeekEnum> getDayOfWeek() {
			return dayOfWeek;
		}
		
		@Override
		@RosettaAttribute("dayNumber")
		public Integer getDayNumber() {
			return dayNumber;
		}
		
		@Override
		public DaysModelSequence1 build() {
			return this;
		}
		
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder toBuilder() {
			DaysModelSequence1.DaysModelSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DaysModelSequence1.DaysModelSequence1Builder builder) {
			ofNullable(getDayOfWeek()).ifPresent(builder::setDayOfWeek);
			ofNullable(getDayNumber()).ifPresent(builder::setDayNumber);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DaysModelSequence1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayNumber, _that.getDayNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(java.lang.Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayNumber != null ? dayNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DaysModelSequence1 {" +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayNumber=" + this.dayNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of DaysModelSequence1  ***********************/
	class DaysModelSequence1BuilderImpl implements DaysModelSequence1.DaysModelSequence1Builder {
	
		protected List<DayOfWeekEnum> dayOfWeek = new ArrayList<>();
		protected Integer dayNumber;
	
		public DaysModelSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dayOfWeek")
		public List<DayOfWeekEnum> getDayOfWeek() {
			return dayOfWeek;
		}
		
		@Override
		@RosettaAttribute("dayNumber")
		public Integer getDayNumber() {
			return dayNumber;
		}
		
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder addDayOfWeek(DayOfWeekEnum dayOfWeek) {
			if (dayOfWeek!=null) this.dayOfWeek.add(dayOfWeek);
			return this;
		}
		
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder addDayOfWeek(DayOfWeekEnum dayOfWeek, int _idx) {
			getIndex(this.dayOfWeek, _idx, () -> dayOfWeek);
			return this;
		}
		@Override 
		public DaysModelSequence1.DaysModelSequence1Builder addDayOfWeek(List<DayOfWeekEnum> dayOfWeeks) {
			if (dayOfWeeks != null) {
				for (DayOfWeekEnum toAdd : dayOfWeeks) {
					this.dayOfWeek.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("dayOfWeek")
		public DaysModelSequence1.DaysModelSequence1Builder setDayOfWeek(List<DayOfWeekEnum> dayOfWeeks) {
			if (dayOfWeeks == null)  {
				this.dayOfWeek = new ArrayList<>();
			}
			else {
				this.dayOfWeek = dayOfWeeks.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("dayNumber")
		public DaysModelSequence1.DaysModelSequence1Builder setDayNumber(Integer dayNumber) {
			this.dayNumber = dayNumber==null?null:dayNumber;
			return this;
		}
		
		@Override
		public DaysModelSequence1 build() {
			return new DaysModelSequence1.DaysModelSequence1Impl(this);
		}
		
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDayOfWeek()!=null && !getDayOfWeek().isEmpty()) return true;
			if (getDayNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DaysModelSequence1.DaysModelSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DaysModelSequence1.DaysModelSequence1Builder o = (DaysModelSequence1.DaysModelSequence1Builder) other;
			
			
			merger.mergeBasic(getDayOfWeek(), o.getDayOfWeek(), (Consumer<DayOfWeekEnum>) this::addDayOfWeek);
			merger.mergeBasic(getDayNumber(), o.getDayNumber(), this::setDayNumber);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DaysModelSequence1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(dayOfWeek, _that.getDayOfWeek())) return false;
			if (!Objects.equals(dayNumber, _that.getDayNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayOfWeek != null ? dayOfWeek.stream().map(java.lang.Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (dayNumber != null ? dayNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DaysModelSequence1Builder {" +
				"dayOfWeek=" + this.dayOfWeek + ", " +
				"dayNumber=" + this.dayNumber +
			'}';
		}
	}
}
