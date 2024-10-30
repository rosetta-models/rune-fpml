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
import fpml.confirmation.Period;
import fpml.confirmation.Period.PeriodBuilder;
import fpml.confirmation.Period.PeriodBuilderImpl;
import fpml.confirmation.Period.PeriodImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.meta.PeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define recurring periods or time offsets.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Period", builder=Period.PeriodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Period extends RosettaModelObject {

	PeriodMeta metaData = new PeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
	 */
	Integer getPeriodMultiplier();
	/**
	 * A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
	 */
	PeriodEnum getPeriod();
	String getId();

	/*********************** Build Methods  ***********************/
	Period build();
	
	Period.PeriodBuilder toBuilder();
	
	static Period.PeriodBuilder builder() {
		return new Period.PeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Period> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Period> getType() {
		return Period.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodBuilder extends Period, RosettaModelObjectBuilder {
		Period.PeriodBuilder setPeriodMultiplier(Integer periodMultiplier);
		Period.PeriodBuilder setPeriod(PeriodEnum period);
		Period.PeriodBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Period.PeriodBuilder prune();
	}

	/*********************** Immutable Implementation of Period  ***********************/
	class PeriodImpl implements Period {
		private final Integer periodMultiplier;
		private final PeriodEnum period;
		private final String id;
		
		protected PeriodImpl(Period.PeriodBuilder builder) {
			this.periodMultiplier = builder.getPeriodMultiplier();
			this.period = builder.getPeriod();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		public PeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Period build() {
			return this;
		}
		
		@Override
		public Period.PeriodBuilder toBuilder() {
			Period.PeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Period.PeriodBuilder builder) {
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Period _that = getType().cast(o);
		
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Period {" +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Period  ***********************/
	class PeriodBuilderImpl implements Period.PeriodBuilder {
	
		protected Integer periodMultiplier;
		protected PeriodEnum period;
		protected String id;
	
		public PeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		public PeriodEnum getPeriod() {
			return period;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public Period.PeriodBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public Period.PeriodBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Period.PeriodBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Period build() {
			return new Period.PeriodImpl(this);
		}
		
		@Override
		public Period.PeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Period.PeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodMultiplier()!=null) return true;
			if (getPeriod()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Period.PeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Period.PeriodBuilder o = (Period.PeriodBuilder) other;
			
			
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Period _that = getType().cast(o);
		
			if (!Objects.equals(periodMultiplier, _that.getPeriodMultiplier())) return false;
			if (!Objects.equals(period, _that.getPeriod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodMultiplier != null ? periodMultiplier.hashCode() : 0);
			_result = 31 * _result + (period != null ? period.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodBuilder {" +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
