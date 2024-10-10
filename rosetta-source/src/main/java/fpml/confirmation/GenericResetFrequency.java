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
import fpml.confirmation.GenericResetFrequency;
import fpml.confirmation.GenericResetFrequency.GenericResetFrequencyBuilder;
import fpml.confirmation.GenericResetFrequency.GenericResetFrequencyBuilderImpl;
import fpml.confirmation.GenericResetFrequency.GenericResetFrequencyImpl;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.UnderlyerReference;
import fpml.confirmation.meta.GenericResetFrequencyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericResetFrequency", builder=GenericResetFrequency.GenericResetFrequencyBuilderImpl.class, version="${project.version}")
public interface GenericResetFrequency extends Frequency {

	GenericResetFrequencyMeta metaData = new GenericResetFrequencyMeta();

	/*********************** Getter Methods  ***********************/
	UnderlyerReference getUnderlyerReference();

	/*********************** Build Methods  ***********************/
	GenericResetFrequency build();
	
	GenericResetFrequency.GenericResetFrequencyBuilder toBuilder();
	
	static GenericResetFrequency.GenericResetFrequencyBuilder builder() {
		return new GenericResetFrequency.GenericResetFrequencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericResetFrequency> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericResetFrequency> getType() {
		return GenericResetFrequency.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.class, getUnderlyerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericResetFrequencyBuilder extends GenericResetFrequency, Frequency.FrequencyBuilder {
		UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference();
		UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference();
		GenericResetFrequency.GenericResetFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier);
		GenericResetFrequency.GenericResetFrequencyBuilder setPeriod(PeriodExtendedEnum period);
		GenericResetFrequency.GenericResetFrequencyBuilder setId(String id);
		GenericResetFrequency.GenericResetFrequencyBuilder setUnderlyerReference(UnderlyerReference underlyerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("underlyerReference"), processor, UnderlyerReference.UnderlyerReferenceBuilder.class, getUnderlyerReference());
		}
		

		GenericResetFrequency.GenericResetFrequencyBuilder prune();
	}

	/*********************** Immutable Implementation of GenericResetFrequency  ***********************/
	class GenericResetFrequencyImpl extends Frequency.FrequencyImpl implements GenericResetFrequency {
		private final UnderlyerReference underlyerReference;
		
		protected GenericResetFrequencyImpl(GenericResetFrequency.GenericResetFrequencyBuilder builder) {
			super(builder);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public UnderlyerReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public GenericResetFrequency build() {
			return this;
		}
		
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder toBuilder() {
			GenericResetFrequency.GenericResetFrequencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericResetFrequency.GenericResetFrequencyBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericResetFrequency {" +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericResetFrequency  ***********************/
	class GenericResetFrequencyBuilderImpl extends Frequency.FrequencyBuilderImpl  implements GenericResetFrequency.GenericResetFrequencyBuilder {
	
		protected UnderlyerReference.UnderlyerReferenceBuilder underlyerReference;
	
		public GenericResetFrequencyBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlyerReference")
		public UnderlyerReference.UnderlyerReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public UnderlyerReference.UnderlyerReferenceBuilder getOrCreateUnderlyerReference() {
			UnderlyerReference.UnderlyerReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = UnderlyerReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public GenericResetFrequency.GenericResetFrequencyBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public GenericResetFrequency.GenericResetFrequencyBuilder setPeriod(PeriodExtendedEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public GenericResetFrequency.GenericResetFrequencyBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("underlyerReference")
		public GenericResetFrequency.GenericResetFrequencyBuilder setUnderlyerReference(UnderlyerReference underlyerReference) {
			this.underlyerReference = underlyerReference==null?null:underlyerReference.toBuilder();
			return this;
		}
		
		@Override
		public GenericResetFrequency build() {
			return new GenericResetFrequency.GenericResetFrequencyImpl(this);
		}
		
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder prune() {
			super.prune();
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericResetFrequency.GenericResetFrequencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GenericResetFrequency.GenericResetFrequencyBuilder o = (GenericResetFrequency.GenericResetFrequencyBuilder) other;
			
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericResetFrequency _that = getType().cast(o);
		
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericResetFrequencyBuilder {" +
				"underlyerReference=" + this.underlyerReference +
			'}' + " " + super.toString();
		}
	}
}
