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
import fpml.confirmation.TimeDimension;
import fpml.confirmation.TimeDimension.TimeDimensionBuilder;
import fpml.confirmation.TimeDimension.TimeDimensionBuilderImpl;
import fpml.confirmation.TimeDimension.TimeDimensionImpl;
import fpml.confirmation.TimeDimensionSequence;
import fpml.confirmation.meta.TimeDimensionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The time dimensions of a term-structure. The user must supply either a tenor or a date or both.
 * @version ${project.version}
 */
@RosettaDataType(value="TimeDimension", builder=TimeDimension.TimeDimensionBuilderImpl.class, version="${project.version}")
public interface TimeDimension extends RosettaModelObject {

	TimeDimensionMeta metaData = new TimeDimensionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount of time from the base date of the pricing input to the specified term point, e.g. 6M or 5Y.
	 */
	Period getTenor();
	TimeDimensionSequence getTimeDimensionSequence();

	/*********************** Build Methods  ***********************/
	TimeDimension build();
	
	TimeDimension.TimeDimensionBuilder toBuilder();
	
	static TimeDimension.TimeDimensionBuilder builder() {
		return new TimeDimension.TimeDimensionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TimeDimension> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TimeDimension> getType() {
		return TimeDimension.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tenor"), processor, Period.class, getTenor());
		processRosetta(path.newSubPath("timeDimensionSequence"), processor, TimeDimensionSequence.class, getTimeDimensionSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TimeDimensionBuilder extends TimeDimension, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateTenor();
		Period.PeriodBuilder getTenor();
		TimeDimensionSequence.TimeDimensionSequenceBuilder getOrCreateTimeDimensionSequence();
		TimeDimensionSequence.TimeDimensionSequenceBuilder getTimeDimensionSequence();
		TimeDimension.TimeDimensionBuilder setTenor(Period tenor);
		TimeDimension.TimeDimensionBuilder setTimeDimensionSequence(TimeDimensionSequence timeDimensionSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tenor"), processor, Period.PeriodBuilder.class, getTenor());
			processRosetta(path.newSubPath("timeDimensionSequence"), processor, TimeDimensionSequence.TimeDimensionSequenceBuilder.class, getTimeDimensionSequence());
		}
		

		TimeDimension.TimeDimensionBuilder prune();
	}

	/*********************** Immutable Implementation of TimeDimension  ***********************/
	class TimeDimensionImpl implements TimeDimension {
		private final Period tenor;
		private final TimeDimensionSequence timeDimensionSequence;
		
		protected TimeDimensionImpl(TimeDimension.TimeDimensionBuilder builder) {
			this.tenor = ofNullable(builder.getTenor()).map(f->f.build()).orElse(null);
			this.timeDimensionSequence = ofNullable(builder.getTimeDimensionSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tenor")
		public Period getTenor() {
			return tenor;
		}
		
		@Override
		@RosettaAttribute("timeDimensionSequence")
		public TimeDimensionSequence getTimeDimensionSequence() {
			return timeDimensionSequence;
		}
		
		@Override
		public TimeDimension build() {
			return this;
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder toBuilder() {
			TimeDimension.TimeDimensionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TimeDimension.TimeDimensionBuilder builder) {
			ofNullable(getTenor()).ifPresent(builder::setTenor);
			ofNullable(getTimeDimensionSequence()).ifPresent(builder::setTimeDimensionSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeDimension _that = getType().cast(o);
		
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			if (!Objects.equals(timeDimensionSequence, _that.getTimeDimensionSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			_result = 31 * _result + (timeDimensionSequence != null ? timeDimensionSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeDimension {" +
				"tenor=" + this.tenor + ", " +
				"timeDimensionSequence=" + this.timeDimensionSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of TimeDimension  ***********************/
	class TimeDimensionBuilderImpl implements TimeDimension.TimeDimensionBuilder {
	
		protected Period.PeriodBuilder tenor;
		protected TimeDimensionSequence.TimeDimensionSequenceBuilder timeDimensionSequence;
	
		public TimeDimensionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tenor")
		public Period.PeriodBuilder getTenor() {
			return tenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenor() {
			Period.PeriodBuilder result;
			if (tenor!=null) {
				result = tenor;
			}
			else {
				result = tenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timeDimensionSequence")
		public TimeDimensionSequence.TimeDimensionSequenceBuilder getTimeDimensionSequence() {
			return timeDimensionSequence;
		}
		
		@Override
		public TimeDimensionSequence.TimeDimensionSequenceBuilder getOrCreateTimeDimensionSequence() {
			TimeDimensionSequence.TimeDimensionSequenceBuilder result;
			if (timeDimensionSequence!=null) {
				result = timeDimensionSequence;
			}
			else {
				result = timeDimensionSequence = TimeDimensionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenor")
		public TimeDimension.TimeDimensionBuilder setTenor(Period tenor) {
			this.tenor = tenor==null?null:tenor.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("timeDimensionSequence")
		public TimeDimension.TimeDimensionBuilder setTimeDimensionSequence(TimeDimensionSequence timeDimensionSequence) {
			this.timeDimensionSequence = timeDimensionSequence==null?null:timeDimensionSequence.toBuilder();
			return this;
		}
		
		@Override
		public TimeDimension build() {
			return new TimeDimension.TimeDimensionImpl(this);
		}
		
		@Override
		public TimeDimension.TimeDimensionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeDimension.TimeDimensionBuilder prune() {
			if (tenor!=null && !tenor.prune().hasData()) tenor = null;
			if (timeDimensionSequence!=null && !timeDimensionSequence.prune().hasData()) timeDimensionSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTenor()!=null && getTenor().hasData()) return true;
			if (getTimeDimensionSequence()!=null && getTimeDimensionSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TimeDimension.TimeDimensionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TimeDimension.TimeDimensionBuilder o = (TimeDimension.TimeDimensionBuilder) other;
			
			merger.mergeRosetta(getTenor(), o.getTenor(), this::setTenor);
			merger.mergeRosetta(getTimeDimensionSequence(), o.getTimeDimensionSequence(), this::setTimeDimensionSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TimeDimension _that = getType().cast(o);
		
			if (!Objects.equals(tenor, _that.getTenor())) return false;
			if (!Objects.equals(timeDimensionSequence, _that.getTimeDimensionSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tenor != null ? tenor.hashCode() : 0);
			_result = 31 * _result + (timeDimensionSequence != null ? timeDimensionSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TimeDimensionBuilder {" +
				"tenor=" + this.tenor + ", " +
				"timeDimensionSequence=" + this.timeDimensionSequence +
			'}';
		}
	}
}
