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
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.EarlyTerminationProvision.EarlyTerminationProvisionBuilder;
import fpml.confirmation.EarlyTerminationProvision.EarlyTerminationProvisionBuilderImpl;
import fpml.confirmation.EarlyTerminationProvision.EarlyTerminationProvisionImpl;
import fpml.confirmation.EarlyTerminationProvisionSequence;
import fpml.confirmation.OptionalEarlyTerminationModel;
import fpml.confirmation.meta.EarlyTerminationProvisionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining an early termination provision for a swap. This early termination is at fair value, i.e. on termination the fair value of the product must be settled between the parties.
 * @version ${project.version}
 */
@RosettaDataType(value="EarlyTerminationProvision", builder=EarlyTerminationProvision.EarlyTerminationProvisionBuilderImpl.class, version="${project.version}")
public interface EarlyTerminationProvision extends RosettaModelObject {

	EarlyTerminationProvisionMeta metaData = new EarlyTerminationProvisionMeta();

	/*********************** Getter Methods  ***********************/
	EarlyTerminationProvisionSequence getEarlyTerminationProvisionSequence();
	OptionalEarlyTerminationModel getOptionalEarlyTerminationModel();
	String getId();

	/*********************** Build Methods  ***********************/
	EarlyTerminationProvision build();
	
	EarlyTerminationProvision.EarlyTerminationProvisionBuilder toBuilder();
	
	static EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder() {
		return new EarlyTerminationProvision.EarlyTerminationProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EarlyTerminationProvision> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EarlyTerminationProvision> getType() {
		return EarlyTerminationProvision.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("earlyTerminationProvisionSequence"), processor, EarlyTerminationProvisionSequence.class, getEarlyTerminationProvisionSequence());
		processRosetta(path.newSubPath("optionalEarlyTerminationModel"), processor, OptionalEarlyTerminationModel.class, getOptionalEarlyTerminationModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EarlyTerminationProvisionBuilder extends EarlyTerminationProvision, RosettaModelObjectBuilder {
		EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder getOrCreateEarlyTerminationProvisionSequence();
		EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder getEarlyTerminationProvisionSequence();
		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOrCreateOptionalEarlyTerminationModel();
		OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOptionalEarlyTerminationModel();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setEarlyTerminationProvisionSequence(EarlyTerminationProvisionSequence earlyTerminationProvisionSequence);
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setOptionalEarlyTerminationModel(OptionalEarlyTerminationModel optionalEarlyTerminationModel);
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("earlyTerminationProvisionSequence"), processor, EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder.class, getEarlyTerminationProvisionSequence());
			processRosetta(path.newSubPath("optionalEarlyTerminationModel"), processor, OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder.class, getOptionalEarlyTerminationModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		EarlyTerminationProvision.EarlyTerminationProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of EarlyTerminationProvision  ***********************/
	class EarlyTerminationProvisionImpl implements EarlyTerminationProvision {
		private final EarlyTerminationProvisionSequence earlyTerminationProvisionSequence;
		private final OptionalEarlyTerminationModel optionalEarlyTerminationModel;
		private final String id;
		
		protected EarlyTerminationProvisionImpl(EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder) {
			this.earlyTerminationProvisionSequence = ofNullable(builder.getEarlyTerminationProvisionSequence()).map(f->f.build()).orElse(null);
			this.optionalEarlyTerminationModel = ofNullable(builder.getOptionalEarlyTerminationModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvisionSequence")
		public EarlyTerminationProvisionSequence getEarlyTerminationProvisionSequence() {
			return earlyTerminationProvisionSequence;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationModel")
		public OptionalEarlyTerminationModel getOptionalEarlyTerminationModel() {
			return optionalEarlyTerminationModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public EarlyTerminationProvision build() {
			return this;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder toBuilder() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EarlyTerminationProvision.EarlyTerminationProvisionBuilder builder) {
			ofNullable(getEarlyTerminationProvisionSequence()).ifPresent(builder::setEarlyTerminationProvisionSequence);
			ofNullable(getOptionalEarlyTerminationModel()).ifPresent(builder::setOptionalEarlyTerminationModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationProvision _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationProvisionSequence, _that.getEarlyTerminationProvisionSequence())) return false;
			if (!Objects.equals(optionalEarlyTerminationModel, _that.getOptionalEarlyTerminationModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationProvisionSequence != null ? earlyTerminationProvisionSequence.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationModel != null ? optionalEarlyTerminationModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationProvision {" +
				"earlyTerminationProvisionSequence=" + this.earlyTerminationProvisionSequence + ", " +
				"optionalEarlyTerminationModel=" + this.optionalEarlyTerminationModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of EarlyTerminationProvision  ***********************/
	class EarlyTerminationProvisionBuilderImpl implements EarlyTerminationProvision.EarlyTerminationProvisionBuilder {
	
		protected EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder earlyTerminationProvisionSequence;
		protected OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder optionalEarlyTerminationModel;
		protected String id;
	
		public EarlyTerminationProvisionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("earlyTerminationProvisionSequence")
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder getEarlyTerminationProvisionSequence() {
			return earlyTerminationProvisionSequence;
		}
		
		@Override
		public EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder getOrCreateEarlyTerminationProvisionSequence() {
			EarlyTerminationProvisionSequence.EarlyTerminationProvisionSequenceBuilder result;
			if (earlyTerminationProvisionSequence!=null) {
				result = earlyTerminationProvisionSequence;
			}
			else {
				result = earlyTerminationProvisionSequence = EarlyTerminationProvisionSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationModel")
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOptionalEarlyTerminationModel() {
			return optionalEarlyTerminationModel;
		}
		
		@Override
		public OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder getOrCreateOptionalEarlyTerminationModel() {
			OptionalEarlyTerminationModel.OptionalEarlyTerminationModelBuilder result;
			if (optionalEarlyTerminationModel!=null) {
				result = optionalEarlyTerminationModel;
			}
			else {
				result = optionalEarlyTerminationModel = OptionalEarlyTerminationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvisionSequence")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setEarlyTerminationProvisionSequence(EarlyTerminationProvisionSequence earlyTerminationProvisionSequence) {
			this.earlyTerminationProvisionSequence = earlyTerminationProvisionSequence==null?null:earlyTerminationProvisionSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTerminationModel")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setOptionalEarlyTerminationModel(OptionalEarlyTerminationModel optionalEarlyTerminationModel) {
			this.optionalEarlyTerminationModel = optionalEarlyTerminationModel==null?null:optionalEarlyTerminationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public EarlyTerminationProvision build() {
			return new EarlyTerminationProvision.EarlyTerminationProvisionImpl(this);
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder prune() {
			if (earlyTerminationProvisionSequence!=null && !earlyTerminationProvisionSequence.prune().hasData()) earlyTerminationProvisionSequence = null;
			if (optionalEarlyTerminationModel!=null && !optionalEarlyTerminationModel.prune().hasData()) optionalEarlyTerminationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEarlyTerminationProvisionSequence()!=null && getEarlyTerminationProvisionSequence().hasData()) return true;
			if (getOptionalEarlyTerminationModel()!=null && getOptionalEarlyTerminationModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder o = (EarlyTerminationProvision.EarlyTerminationProvisionBuilder) other;
			
			merger.mergeRosetta(getEarlyTerminationProvisionSequence(), o.getEarlyTerminationProvisionSequence(), this::setEarlyTerminationProvisionSequence);
			merger.mergeRosetta(getOptionalEarlyTerminationModel(), o.getOptionalEarlyTerminationModel(), this::setOptionalEarlyTerminationModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EarlyTerminationProvision _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationProvisionSequence, _that.getEarlyTerminationProvisionSequence())) return false;
			if (!Objects.equals(optionalEarlyTerminationModel, _that.getOptionalEarlyTerminationModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationProvisionSequence != null ? earlyTerminationProvisionSequence.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationModel != null ? optionalEarlyTerminationModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EarlyTerminationProvisionBuilder {" +
				"earlyTerminationProvisionSequence=" + this.earlyTerminationProvisionSequence + ", " +
				"optionalEarlyTerminationModel=" + this.optionalEarlyTerminationModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
