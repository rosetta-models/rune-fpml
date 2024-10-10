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
import fpml.confirmation.CorrelationId;
import fpml.confirmation.CorrelationIdModel;
import fpml.confirmation.CorrelationModel;
import fpml.confirmation.CorrelationModel.CorrelationModelBuilder;
import fpml.confirmation.CorrelationModel.CorrelationModelBuilderImpl;
import fpml.confirmation.CorrelationModel.CorrelationModelImpl;
import fpml.confirmation.meta.CorrelationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group defining the elements used for process correlation. The correlation ID is used to link followup corrections and retractions to the original request, and to help identify which replies link to which requests. The parent correlation ID is used to keep track of the parent process.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationModel", builder=CorrelationModel.CorrelationModelBuilderImpl.class, version="${project.version}")
public interface CorrelationModel extends RosettaModelObject {

	CorrelationModelMeta metaData = new CorrelationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An optional identifier used to correlate between related processes
	 */
	CorrelationId getParentCorrelationId();
	CorrelationIdModel getCorrelationIdModel();

	/*********************** Build Methods  ***********************/
	CorrelationModel build();
	
	CorrelationModel.CorrelationModelBuilder toBuilder();
	
	static CorrelationModel.CorrelationModelBuilder builder() {
		return new CorrelationModel.CorrelationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationModel> getType() {
		return CorrelationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationIdModel"), processor, CorrelationIdModel.class, getCorrelationIdModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationModelBuilder extends CorrelationModel, RosettaModelObjectBuilder {
		CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId();
		CorrelationId.CorrelationIdBuilder getParentCorrelationId();
		CorrelationIdModel.CorrelationIdModelBuilder getOrCreateCorrelationIdModel();
		CorrelationIdModel.CorrelationIdModelBuilder getCorrelationIdModel();
		CorrelationModel.CorrelationModelBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		CorrelationModel.CorrelationModelBuilder setCorrelationIdModel(CorrelationIdModel correlationIdModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationIdModel"), processor, CorrelationIdModel.CorrelationIdModelBuilder.class, getCorrelationIdModel());
		}
		

		CorrelationModel.CorrelationModelBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationModel  ***********************/
	class CorrelationModelImpl implements CorrelationModel {
		private final CorrelationId parentCorrelationId;
		private final CorrelationIdModel correlationIdModel;
		
		protected CorrelationModelImpl(CorrelationModel.CorrelationModelBuilder builder) {
			this.parentCorrelationId = ofNullable(builder.getParentCorrelationId()).map(f->f.build()).orElse(null);
			this.correlationIdModel = ofNullable(builder.getCorrelationIdModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("parentCorrelationId")
		public CorrelationId getParentCorrelationId() {
			return parentCorrelationId;
		}
		
		@Override
		@RosettaAttribute("correlationIdModel")
		public CorrelationIdModel getCorrelationIdModel() {
			return correlationIdModel;
		}
		
		@Override
		public CorrelationModel build() {
			return this;
		}
		
		@Override
		public CorrelationModel.CorrelationModelBuilder toBuilder() {
			CorrelationModel.CorrelationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationModel.CorrelationModelBuilder builder) {
			ofNullable(getParentCorrelationId()).ifPresent(builder::setParentCorrelationId);
			ofNullable(getCorrelationIdModel()).ifPresent(builder::setCorrelationIdModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationModel _that = getType().cast(o);
		
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!Objects.equals(correlationIdModel, _that.getCorrelationIdModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationIdModel != null ? correlationIdModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationModel {" +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationIdModel=" + this.correlationIdModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrelationModel  ***********************/
	class CorrelationModelBuilderImpl implements CorrelationModel.CorrelationModelBuilder {
	
		protected CorrelationId.CorrelationIdBuilder parentCorrelationId;
		protected CorrelationIdModel.CorrelationIdModelBuilder correlationIdModel;
	
		public CorrelationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("parentCorrelationId")
		public CorrelationId.CorrelationIdBuilder getParentCorrelationId() {
			return parentCorrelationId;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder getOrCreateParentCorrelationId() {
			CorrelationId.CorrelationIdBuilder result;
			if (parentCorrelationId!=null) {
				result = parentCorrelationId;
			}
			else {
				result = parentCorrelationId = CorrelationId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationIdModel")
		public CorrelationIdModel.CorrelationIdModelBuilder getCorrelationIdModel() {
			return correlationIdModel;
		}
		
		@Override
		public CorrelationIdModel.CorrelationIdModelBuilder getOrCreateCorrelationIdModel() {
			CorrelationIdModel.CorrelationIdModelBuilder result;
			if (correlationIdModel!=null) {
				result = correlationIdModel;
			}
			else {
				result = correlationIdModel = CorrelationIdModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parentCorrelationId")
		public CorrelationModel.CorrelationModelBuilder setParentCorrelationId(CorrelationId parentCorrelationId) {
			this.parentCorrelationId = parentCorrelationId==null?null:parentCorrelationId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationIdModel")
		public CorrelationModel.CorrelationModelBuilder setCorrelationIdModel(CorrelationIdModel correlationIdModel) {
			this.correlationIdModel = correlationIdModel==null?null:correlationIdModel.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationModel build() {
			return new CorrelationModel.CorrelationModelImpl(this);
		}
		
		@Override
		public CorrelationModel.CorrelationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationModel.CorrelationModelBuilder prune() {
			if (parentCorrelationId!=null && !parentCorrelationId.prune().hasData()) parentCorrelationId = null;
			if (correlationIdModel!=null && !correlationIdModel.prune().hasData()) correlationIdModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParentCorrelationId()!=null && getParentCorrelationId().hasData()) return true;
			if (getCorrelationIdModel()!=null && getCorrelationIdModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationModel.CorrelationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrelationModel.CorrelationModelBuilder o = (CorrelationModel.CorrelationModelBuilder) other;
			
			merger.mergeRosetta(getParentCorrelationId(), o.getParentCorrelationId(), this::setParentCorrelationId);
			merger.mergeRosetta(getCorrelationIdModel(), o.getCorrelationIdModel(), this::setCorrelationIdModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationModel _that = getType().cast(o);
		
			if (!Objects.equals(parentCorrelationId, _that.getParentCorrelationId())) return false;
			if (!Objects.equals(correlationIdModel, _that.getCorrelationIdModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parentCorrelationId != null ? parentCorrelationId.hashCode() : 0);
			_result = 31 * _result + (correlationIdModel != null ? correlationIdModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationModelBuilder {" +
				"parentCorrelationId=" + this.parentCorrelationId + ", " +
				"correlationIdModel=" + this.correlationIdModel +
			'}';
		}
	}
}
