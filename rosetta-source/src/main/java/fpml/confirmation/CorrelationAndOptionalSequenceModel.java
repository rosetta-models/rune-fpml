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
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder;
import fpml.confirmation.CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilderImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelImpl;
import fpml.confirmation.CorrelationModel;
import fpml.confirmation.SequenceModel;
import fpml.confirmation.meta.CorrelationAndOptionalSequenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group defining the full messsage correlation mechanism, but with optional sequence. Please note that for reports in Reporting view, usage of the correlation and sequence model is not well defined in the standard an may be deprecated from future versions of the standard. Use the ReportReference structure to identify report instances and section numbers if a report must be divided into chunks.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationAndOptionalSequenceModel", builder=CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilderImpl.class, version="${project.version}")
public interface CorrelationAndOptionalSequenceModel extends RosettaModelObject {

	CorrelationAndOptionalSequenceModelMeta metaData = new CorrelationAndOptionalSequenceModelMeta();

	/*********************** Getter Methods  ***********************/
	CorrelationModel getCorrelationModel();
	SequenceModel getSequenceModel();

	/*********************** Build Methods  ***********************/
	CorrelationAndOptionalSequenceModel build();
	
	CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder toBuilder();
	
	static CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder builder() {
		return new CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationAndOptionalSequenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationAndOptionalSequenceModel> getType() {
		return CorrelationAndOptionalSequenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("correlationModel"), processor, CorrelationModel.class, getCorrelationModel());
		processRosetta(path.newSubPath("sequenceModel"), processor, SequenceModel.class, getSequenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationAndOptionalSequenceModelBuilder extends CorrelationAndOptionalSequenceModel, RosettaModelObjectBuilder {
		CorrelationModel.CorrelationModelBuilder getOrCreateCorrelationModel();
		CorrelationModel.CorrelationModelBuilder getCorrelationModel();
		SequenceModel.SequenceModelBuilder getOrCreateSequenceModel();
		SequenceModel.SequenceModelBuilder getSequenceModel();
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder setCorrelationModel(CorrelationModel correlationModel);
		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder setSequenceModel(SequenceModel sequenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("correlationModel"), processor, CorrelationModel.CorrelationModelBuilder.class, getCorrelationModel());
			processRosetta(path.newSubPath("sequenceModel"), processor, SequenceModel.SequenceModelBuilder.class, getSequenceModel());
		}
		

		CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationAndOptionalSequenceModel  ***********************/
	class CorrelationAndOptionalSequenceModelImpl implements CorrelationAndOptionalSequenceModel {
		private final CorrelationModel correlationModel;
		private final SequenceModel sequenceModel;
		
		protected CorrelationAndOptionalSequenceModelImpl(CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder builder) {
			this.correlationModel = ofNullable(builder.getCorrelationModel()).map(f->f.build()).orElse(null);
			this.sequenceModel = ofNullable(builder.getSequenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationModel")
		public CorrelationModel getCorrelationModel() {
			return correlationModel;
		}
		
		@Override
		@RosettaAttribute("sequenceModel")
		public SequenceModel getSequenceModel() {
			return sequenceModel;
		}
		
		@Override
		public CorrelationAndOptionalSequenceModel build() {
			return this;
		}
		
		@Override
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder toBuilder() {
			CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder builder) {
			ofNullable(getCorrelationModel()).ifPresent(builder::setCorrelationModel);
			ofNullable(getSequenceModel()).ifPresent(builder::setSequenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationAndOptionalSequenceModel _that = getType().cast(o);
		
			if (!Objects.equals(correlationModel, _that.getCorrelationModel())) return false;
			if (!Objects.equals(sequenceModel, _that.getSequenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationModel != null ? correlationModel.hashCode() : 0);
			_result = 31 * _result + (sequenceModel != null ? sequenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationAndOptionalSequenceModel {" +
				"correlationModel=" + this.correlationModel + ", " +
				"sequenceModel=" + this.sequenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrelationAndOptionalSequenceModel  ***********************/
	class CorrelationAndOptionalSequenceModelBuilderImpl implements CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder {
	
		protected CorrelationModel.CorrelationModelBuilder correlationModel;
		protected SequenceModel.SequenceModelBuilder sequenceModel;
	
		public CorrelationAndOptionalSequenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("correlationModel")
		public CorrelationModel.CorrelationModelBuilder getCorrelationModel() {
			return correlationModel;
		}
		
		@Override
		public CorrelationModel.CorrelationModelBuilder getOrCreateCorrelationModel() {
			CorrelationModel.CorrelationModelBuilder result;
			if (correlationModel!=null) {
				result = correlationModel;
			}
			else {
				result = correlationModel = CorrelationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sequenceModel")
		public SequenceModel.SequenceModelBuilder getSequenceModel() {
			return sequenceModel;
		}
		
		@Override
		public SequenceModel.SequenceModelBuilder getOrCreateSequenceModel() {
			SequenceModel.SequenceModelBuilder result;
			if (sequenceModel!=null) {
				result = sequenceModel;
			}
			else {
				result = sequenceModel = SequenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationModel")
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder setCorrelationModel(CorrelationModel correlationModel) {
			this.correlationModel = correlationModel==null?null:correlationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sequenceModel")
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder setSequenceModel(SequenceModel sequenceModel) {
			this.sequenceModel = sequenceModel==null?null:sequenceModel.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationAndOptionalSequenceModel build() {
			return new CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelImpl(this);
		}
		
		@Override
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder prune() {
			if (correlationModel!=null && !correlationModel.prune().hasData()) correlationModel = null;
			if (sequenceModel!=null && !sequenceModel.prune().hasData()) sequenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCorrelationModel()!=null && getCorrelationModel().hasData()) return true;
			if (getSequenceModel()!=null && getSequenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder o = (CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder) other;
			
			merger.mergeRosetta(getCorrelationModel(), o.getCorrelationModel(), this::setCorrelationModel);
			merger.mergeRosetta(getSequenceModel(), o.getSequenceModel(), this::setSequenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationAndOptionalSequenceModel _that = getType().cast(o);
		
			if (!Objects.equals(correlationModel, _that.getCorrelationModel())) return false;
			if (!Objects.equals(sequenceModel, _that.getSequenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationModel != null ? correlationModel.hashCode() : 0);
			_result = 31 * _result + (sequenceModel != null ? sequenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationAndOptionalSequenceModelBuilder {" +
				"correlationModel=" + this.correlationModel + ", " +
				"sequenceModel=" + this.sequenceModel +
			'}';
		}
	}
}
