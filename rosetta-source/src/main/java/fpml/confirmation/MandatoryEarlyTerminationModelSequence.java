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
import fpml.confirmation.MandatoryEarlyTermination;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilderImpl;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.MandatoryEarlyTerminationModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MandatoryEarlyTerminationModelSequence", builder=MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilderImpl.class, version="${project.version}")
public interface MandatoryEarlyTerminationModelSequence extends RosettaModelObject {

	MandatoryEarlyTerminationModelSequenceMeta metaData = new MandatoryEarlyTerminationModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Period after trade date of the mandatory early termination date.
	 */
	Period getMandatoryEarlyTerminationDateTenor();
	/**
	 * A mandatory early termination provision to terminate the swap at fair value.
	 */
	MandatoryEarlyTermination getMandatoryEarlyTermination();

	/*********************** Build Methods  ***********************/
	MandatoryEarlyTerminationModelSequence build();
	
	MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder toBuilder();
	
	static MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder builder() {
		return new MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryEarlyTerminationModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MandatoryEarlyTerminationModelSequence> getType() {
		return MandatoryEarlyTerminationModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mandatoryEarlyTerminationDateTenor"), processor, Period.class, getMandatoryEarlyTerminationDateTenor());
		processRosetta(path.newSubPath("mandatoryEarlyTermination"), processor, MandatoryEarlyTermination.class, getMandatoryEarlyTermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MandatoryEarlyTerminationModelSequenceBuilder extends MandatoryEarlyTerminationModelSequence, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateMandatoryEarlyTerminationDateTenor();
		Period.PeriodBuilder getMandatoryEarlyTerminationDateTenor();
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getOrCreateMandatoryEarlyTermination();
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getMandatoryEarlyTermination();
		MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder setMandatoryEarlyTerminationDateTenor(Period mandatoryEarlyTerminationDateTenor);
		MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder setMandatoryEarlyTermination(MandatoryEarlyTermination mandatoryEarlyTermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mandatoryEarlyTerminationDateTenor"), processor, Period.PeriodBuilder.class, getMandatoryEarlyTerminationDateTenor());
			processRosetta(path.newSubPath("mandatoryEarlyTermination"), processor, MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder.class, getMandatoryEarlyTermination());
		}
		

		MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryEarlyTerminationModelSequence  ***********************/
	class MandatoryEarlyTerminationModelSequenceImpl implements MandatoryEarlyTerminationModelSequence {
		private final Period mandatoryEarlyTerminationDateTenor;
		private final MandatoryEarlyTermination mandatoryEarlyTermination;
		
		protected MandatoryEarlyTerminationModelSequenceImpl(MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder builder) {
			this.mandatoryEarlyTerminationDateTenor = ofNullable(builder.getMandatoryEarlyTerminationDateTenor()).map(f->f.build()).orElse(null);
			this.mandatoryEarlyTermination = ofNullable(builder.getMandatoryEarlyTermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDateTenor")
		public Period getMandatoryEarlyTerminationDateTenor() {
			return mandatoryEarlyTerminationDateTenor;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTermination getMandatoryEarlyTermination() {
			return mandatoryEarlyTermination;
		}
		
		@Override
		public MandatoryEarlyTerminationModelSequence build() {
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder toBuilder() {
			MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder builder) {
			ofNullable(getMandatoryEarlyTerminationDateTenor()).ifPresent(builder::setMandatoryEarlyTerminationDateTenor);
			ofNullable(getMandatoryEarlyTermination()).ifPresent(builder::setMandatoryEarlyTermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTerminationDateTenor, _that.getMandatoryEarlyTerminationDateTenor())) return false;
			if (!Objects.equals(mandatoryEarlyTermination, _that.getMandatoryEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTerminationDateTenor != null ? mandatoryEarlyTerminationDateTenor.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTermination != null ? mandatoryEarlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationModelSequence {" +
				"mandatoryEarlyTerminationDateTenor=" + this.mandatoryEarlyTerminationDateTenor + ", " +
				"mandatoryEarlyTermination=" + this.mandatoryEarlyTermination +
			'}';
		}
	}

	/*********************** Builder Implementation of MandatoryEarlyTerminationModelSequence  ***********************/
	class MandatoryEarlyTerminationModelSequenceBuilderImpl implements MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder {
	
		protected Period.PeriodBuilder mandatoryEarlyTerminationDateTenor;
		protected MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder mandatoryEarlyTermination;
	
		public MandatoryEarlyTerminationModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDateTenor")
		public Period.PeriodBuilder getMandatoryEarlyTerminationDateTenor() {
			return mandatoryEarlyTerminationDateTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateMandatoryEarlyTerminationDateTenor() {
			Period.PeriodBuilder result;
			if (mandatoryEarlyTerminationDateTenor!=null) {
				result = mandatoryEarlyTerminationDateTenor;
			}
			else {
				result = mandatoryEarlyTerminationDateTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getMandatoryEarlyTermination() {
			return mandatoryEarlyTermination;
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder getOrCreateMandatoryEarlyTermination() {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder result;
			if (mandatoryEarlyTermination!=null) {
				result = mandatoryEarlyTermination;
			}
			else {
				result = mandatoryEarlyTermination = MandatoryEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDateTenor")
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder setMandatoryEarlyTerminationDateTenor(Period mandatoryEarlyTerminationDateTenor) {
			this.mandatoryEarlyTerminationDateTenor = mandatoryEarlyTerminationDateTenor==null?null:mandatoryEarlyTerminationDateTenor.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mandatoryEarlyTermination")
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder setMandatoryEarlyTermination(MandatoryEarlyTermination mandatoryEarlyTermination) {
			this.mandatoryEarlyTermination = mandatoryEarlyTermination==null?null:mandatoryEarlyTermination.toBuilder();
			return this;
		}
		
		@Override
		public MandatoryEarlyTerminationModelSequence build() {
			return new MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceImpl(this);
		}
		
		@Override
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder prune() {
			if (mandatoryEarlyTerminationDateTenor!=null && !mandatoryEarlyTerminationDateTenor.prune().hasData()) mandatoryEarlyTerminationDateTenor = null;
			if (mandatoryEarlyTermination!=null && !mandatoryEarlyTermination.prune().hasData()) mandatoryEarlyTermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMandatoryEarlyTerminationDateTenor()!=null && getMandatoryEarlyTerminationDateTenor().hasData()) return true;
			if (getMandatoryEarlyTermination()!=null && getMandatoryEarlyTermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder o = (MandatoryEarlyTerminationModelSequence.MandatoryEarlyTerminationModelSequenceBuilder) other;
			
			merger.mergeRosetta(getMandatoryEarlyTerminationDateTenor(), o.getMandatoryEarlyTerminationDateTenor(), this::setMandatoryEarlyTerminationDateTenor);
			merger.mergeRosetta(getMandatoryEarlyTermination(), o.getMandatoryEarlyTermination(), this::setMandatoryEarlyTermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTerminationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(mandatoryEarlyTerminationDateTenor, _that.getMandatoryEarlyTerminationDateTenor())) return false;
			if (!Objects.equals(mandatoryEarlyTermination, _that.getMandatoryEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mandatoryEarlyTerminationDateTenor != null ? mandatoryEarlyTerminationDateTenor.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTermination != null ? mandatoryEarlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationModelSequenceBuilder {" +
				"mandatoryEarlyTerminationDateTenor=" + this.mandatoryEarlyTerminationDateTenor + ", " +
				"mandatoryEarlyTermination=" + this.mandatoryEarlyTermination +
			'}';
		}
	}
}
