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
import fpml.confirmation.Frequency;
import fpml.confirmation.Frequency.FrequencyBuilder;
import fpml.confirmation.Frequency.FrequencyBuilderImpl;
import fpml.confirmation.Frequency.FrequencyImpl;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.meta.FrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a time frequency, e.g. one day, three months. Used for specifying payment or calculation frequencies at which the value T (Term) is applicable.
 * @version ${project.version}
 */
@RosettaDataType(value="Frequency", builder=Frequency.FrequencyBuilderImpl.class, version="${project.version}")
public interface Frequency extends RosettaModelObject {

	FrequencyMeta metaData = new FrequencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A time period multiplier, e.g. 1, 2 or 3 etc. If the period value is T (Term) then periodMultiplier must contain the value 1.
	 */
	Integer getPeriodMultiplier();
	/**
	 * A time period, e.g. a day, week, month, year or term of the stream.
	 */
	PeriodExtendedEnum getPeriod();
	String getId();

	/*********************** Build Methods  ***********************/
	Frequency build();
	
	Frequency.FrequencyBuilder toBuilder();
	
	static Frequency.FrequencyBuilder builder() {
		return new Frequency.FrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Frequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Frequency> getType() {
		return Frequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FrequencyBuilder extends Frequency, RosettaModelObjectBuilder {
		Frequency.FrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		Frequency.FrequencyBuilder setPeriod(PeriodExtendedEnum period);
		Frequency.FrequencyBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Frequency.FrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of Frequency  ***********************/
	class FrequencyImpl implements Frequency {
		private final Integer periodMultiplier;
		private final PeriodExtendedEnum period;
		private final String id;
		
		protected FrequencyImpl(Frequency.FrequencyBuilder builder) {
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
		public PeriodExtendedEnum getPeriod() {
			return period;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Frequency build() {
			return this;
		}
		
		@Override
		public Frequency.FrequencyBuilder toBuilder() {
			Frequency.FrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Frequency.FrequencyBuilder builder) {
			ofNullable(getPeriodMultiplier()).ifPresent(builder::setPeriodMultiplier);
			ofNullable(getPeriod()).ifPresent(builder::setPeriod);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Frequency _that = getType().cast(o);
		
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
			return "Frequency {" +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Frequency  ***********************/
	class FrequencyBuilderImpl implements Frequency.FrequencyBuilder {
	
		protected Integer periodMultiplier;
		protected PeriodExtendedEnum period;
		protected String id;
	
		public FrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodMultiplier")
		public Integer getPeriodMultiplier() {
			return periodMultiplier;
		}
		
		@Override
		@RosettaAttribute("period")
		public PeriodExtendedEnum getPeriod() {
			return period;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public Frequency.FrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public Frequency.FrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Frequency.FrequencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Frequency build() {
			return new Frequency.FrequencyImpl(this);
		}
		
		@Override
		public Frequency.FrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Frequency.FrequencyBuilder prune() {
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
		public Frequency.FrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Frequency.FrequencyBuilder o = (Frequency.FrequencyBuilder) other;
			
			
			merger.mergeBasic(getPeriodMultiplier(), o.getPeriodMultiplier(), this::setPeriodMultiplier);
			merger.mergeBasic(getPeriod(), o.getPeriod(), this::setPeriod);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Frequency _that = getType().cast(o);
		
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
			return "FrequencyBuilder {" +
				"periodMultiplier=" + this.periodMultiplier + ", " +
				"period=" + this.period + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
