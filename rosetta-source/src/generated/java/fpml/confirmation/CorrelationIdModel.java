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
import fpml.confirmation.CorrelationIdModel.CorrelationIdModelBuilder;
import fpml.confirmation.CorrelationIdModel.CorrelationIdModelBuilderImpl;
import fpml.confirmation.CorrelationIdModel.CorrelationIdModelImpl;
import fpml.confirmation.meta.CorrelationIdModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group defining the element used for process correlation. The correlation ID is used to link followup corrections and retractions to the original request, and to help identify which replies link to which requests.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationIdModel", builder=CorrelationIdModel.CorrelationIdModelBuilderImpl.class, version="${project.version}")
public interface CorrelationIdModel extends RosettaModelObject {

	CorrelationIdModelMeta metaData = new CorrelationIdModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A qualified identifier used to correlate between messages
	 */
	CorrelationId getCorrelationId();

	/*********************** Build Methods  ***********************/
	CorrelationIdModel build();
	
	CorrelationIdModel.CorrelationIdModelBuilder toBuilder();
	
	static CorrelationIdModel.CorrelationIdModelBuilder builder() {
		return new CorrelationIdModel.CorrelationIdModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationIdModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationIdModel> getType() {
		return CorrelationIdModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationIdModelBuilder extends CorrelationIdModel, RosettaModelObjectBuilder {
		CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId();
		CorrelationId.CorrelationIdBuilder getCorrelationId();
		CorrelationIdModel.CorrelationIdModelBuilder setCorrelationId(CorrelationId correlationId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
		}
		

		CorrelationIdModel.CorrelationIdModelBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationIdModel  ***********************/
	class CorrelationIdModelImpl implements CorrelationIdModel {
		private final CorrelationId correlationId;
		
		protected CorrelationIdModelImpl(CorrelationIdModel.CorrelationIdModelBuilder builder) {
			this.correlationId = ofNullable(builder.getCorrelationId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("correlationId")
		public CorrelationId getCorrelationId() {
			return correlationId;
		}
		
		@Override
		public CorrelationIdModel build() {
			return this;
		}
		
		@Override
		public CorrelationIdModel.CorrelationIdModelBuilder toBuilder() {
			CorrelationIdModel.CorrelationIdModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationIdModel.CorrelationIdModelBuilder builder) {
			ofNullable(getCorrelationId()).ifPresent(builder::setCorrelationId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationIdModel _that = getType().cast(o);
		
			if (!Objects.equals(correlationId, _that.getCorrelationId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationIdModel {" +
				"correlationId=" + this.correlationId +
			'}';
		}
	}

	/*********************** Builder Implementation of CorrelationIdModel  ***********************/
	class CorrelationIdModelBuilderImpl implements CorrelationIdModel.CorrelationIdModelBuilder {
	
		protected CorrelationId.CorrelationIdBuilder correlationId;
	
		public CorrelationIdModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("correlationId")
		public CorrelationId.CorrelationIdBuilder getCorrelationId() {
			return correlationId;
		}
		
		@Override
		public CorrelationId.CorrelationIdBuilder getOrCreateCorrelationId() {
			CorrelationId.CorrelationIdBuilder result;
			if (correlationId!=null) {
				result = correlationId;
			}
			else {
				result = correlationId = CorrelationId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correlationId")
		public CorrelationIdModel.CorrelationIdModelBuilder setCorrelationId(CorrelationId correlationId) {
			this.correlationId = correlationId==null?null:correlationId.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationIdModel build() {
			return new CorrelationIdModel.CorrelationIdModelImpl(this);
		}
		
		@Override
		public CorrelationIdModel.CorrelationIdModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationIdModel.CorrelationIdModelBuilder prune() {
			if (correlationId!=null && !correlationId.prune().hasData()) correlationId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCorrelationId()!=null && getCorrelationId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationIdModel.CorrelationIdModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CorrelationIdModel.CorrelationIdModelBuilder o = (CorrelationIdModel.CorrelationIdModelBuilder) other;
			
			merger.mergeRosetta(getCorrelationId(), o.getCorrelationId(), this::setCorrelationId);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CorrelationIdModel _that = getType().cast(o);
		
			if (!Objects.equals(correlationId, _that.getCorrelationId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (correlationId != null ? correlationId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorrelationIdModelBuilder {" +
				"correlationId=" + this.correlationId +
			'}';
		}
	}
}
