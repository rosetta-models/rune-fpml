package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.Offset;
import fpml.confirmation.Offset.OffsetBuilder;
import fpml.confirmation.Offset.OffsetBuilderImpl;
import fpml.confirmation.Offset.OffsetImpl;
import fpml.confirmation.Period;
import fpml.confirmation.Period.PeriodBuilder;
import fpml.confirmation.Period.PeriodBuilderImpl;
import fpml.confirmation.Period.PeriodImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.meta.OffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining an offset used in calculating a new date relative to a reference date. E.g. calendar days, business days, Commodity Business days, etc..
 * @version ${project.version}
 */
@RosettaDataType(value="Offset", builder=Offset.OffsetBuilderImpl.class, version="${project.version}")
public interface Offset extends Period {

	OffsetMeta metaData = new OffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
	 */
	DayTypeEnum getDayType();

	/*********************** Build Methods  ***********************/
	Offset build();
	
	Offset.OffsetBuilder toBuilder();
	
	static Offset.OffsetBuilder builder() {
		return new Offset.OffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Offset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Offset> getType() {
		return Offset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OffsetBuilder extends Offset, Period.PeriodBuilder {
		Offset.OffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		Offset.OffsetBuilder setPeriod(PeriodEnum period);
		Offset.OffsetBuilder setId(String id);
		Offset.OffsetBuilder setDayType(DayTypeEnum dayType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		}
		

		Offset.OffsetBuilder prune();
	}

	/*********************** Immutable Implementation of Offset  ***********************/
	class OffsetImpl extends Period.PeriodImpl implements Offset {
		private final DayTypeEnum dayType;
		
		protected OffsetImpl(Offset.OffsetBuilder builder) {
			super(builder);
			this.dayType = builder.getDayType();
		}
		
		@Override
		@RosettaAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		public Offset build() {
			return this;
		}
		
		@Override
		public Offset.OffsetBuilder toBuilder() {
			Offset.OffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Offset.OffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Offset _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Offset {" +
				"dayType=" + this.dayType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Offset  ***********************/
	class OffsetBuilderImpl extends Period.PeriodBuilderImpl  implements Offset.OffsetBuilder {
	
		protected DayTypeEnum dayType;
	
		public OffsetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public Offset.OffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public Offset.OffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Offset.OffsetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public Offset.OffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		
		@Override
		public Offset build() {
			return new Offset.OffsetImpl(this);
		}
		
		@Override
		public Offset.OffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Offset.OffsetBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDayType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Offset.OffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Offset.OffsetBuilder o = (Offset.OffsetBuilder) other;
			
			
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Offset _that = getType().cast(o);
		
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OffsetBuilder {" +
				"dayType=" + this.dayType +
			'}' + " " + super.toString();
		}
	}
}
