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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder;
import fpml.confirmation.CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilderImpl;
import fpml.confirmation.CorrelationAndSequenceModel.CorrelationAndSequenceModelImpl;
import fpml.confirmation.CorrelationModel;
import fpml.confirmation.SequenceModel;
import fpml.confirmation.meta.CorrelationAndSequenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group defining the full messsage correlation mechanism. The correlation ID is used to link followup corrections and retractions to the original request, and to help identify which replies link to which requests. (The &quot;inReplyTo&quot; element may also be used for this purpose, but it contains a message identifier rather than a business object identifier.) The sequence ID is used to establish an ordering between multiple messages related to the same business object (identified by the same correlation identifier). It contains a value the must ascend (possibly with gaps) messages on the same correlation ID.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationAndSequenceModel", builder=CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilderImpl.class, version="${project.version}")
public interface CorrelationAndSequenceModel extends RosettaModelObject {

	CorrelationAndSequenceModelMeta metaData = new CorrelationAndSequenceModelMeta();

	/*********************** Getter Methods  ***********************/
	CorrelationModel getCorrelationModel();
	SequenceModel getSequenceModel();

	/*********************** Build Methods  ***********************/
	CorrelationAndSequenceModel build();
	
	CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder toBuilder();
	
	static CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder builder() {
		return new CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationAndSequenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationAndSequenceModel> getType() {
		return CorrelationAndSequenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("correlationModel"), processor, CorrelationModel.class, getCorrelationModel());
		processRosetta(path.newSubPath("sequenceModel"), processor, SequenceModel.class, getSequenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationAndSequenceModelBuilder extends CorrelationAndSequenceModel, RosettaModelObjectBuilder {
		CorrelationModel.CorrelationModelBuilder getOrCreateCorrelationModel();
		CorrelationModel.CorrelationModelBuilder getCorrelationModel();
		SequenceModel.SequenceModelBuilder getOrCreateSequenceModel();
		SequenceModel.SequenceModelBuilder getSequenceModel();
		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder setCorrelationModel(CorrelationModel correlationModel);
		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder setSequenceModel(SequenceModel sequenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("correlationModel"), processor, CorrelationModel.CorrelationModelBuilder.class, getCorrelationModel());
			processRosetta(path.newSubPath("sequenceModel"), processor, SequenceModel.SequenceModelBuilder.class, getSequenceModel());
		}
		

		CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationAndSequenceModel  ***********************/
	class CorrelationAndSequenceModelImpl implements CorrelationAndSequenceModel {
		private final CorrelationModel correlationModel;
		private final SequenceModel sequenceModel;
		
		protected CorrelationAndSequenceModelImpl(CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder builder) {
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
		public CorrelationAndSequenceModel build() {
			return this;
		}
		
		@Override
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder toBuilder() {
			CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder builder) {
			ofNullable(getCorrelationModel()).ifPresent(builder::setCorrelationModel);
			ofNullable(getSequenceModel()).ifPresent(builder::setSequenceModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationAndSequenceModel _that = getType().cast(o);
		
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
			return "CorrelationAndSequenceModel {" +
				"correlationModel=" + this.correlationModel + ", " +
				"sequenceModel=" + this.sequenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrelationAndSequenceModel  ***********************/
	class CorrelationAndSequenceModelBuilderImpl implements CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder {
	
		protected CorrelationModel.CorrelationModelBuilder correlationModel;
		protected SequenceModel.SequenceModelBuilder sequenceModel;
	
		public CorrelationAndSequenceModelBuilderImpl() {
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
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder setCorrelationModel(CorrelationModel correlationModel) {
			this.correlationModel = correlationModel==null?null:correlationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sequenceModel")
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder setSequenceModel(SequenceModel sequenceModel) {
			this.sequenceModel = sequenceModel==null?null:sequenceModel.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationAndSequenceModel build() {
			return new CorrelationAndSequenceModel.CorrelationAndSequenceModelImpl(this);
		}
		
		@Override
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder prune() {
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
		public CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder o = (CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder) other;
			
			merger.mergeRosetta(getCorrelationModel(), o.getCorrelationModel(), this::setCorrelationModel);
			merger.mergeRosetta(getSequenceModel(), o.getSequenceModel(), this::setSequenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationAndSequenceModel _that = getType().cast(o);
		
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
			return "CorrelationAndSequenceModelBuilder {" +
				"correlationModel=" + this.correlationModel + ", " +
				"sequenceModel=" + this.sequenceModel +
			'}';
		}
	}
}
