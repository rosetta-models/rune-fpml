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
import fpml.confirmation.SequenceModel;
import fpml.confirmation.SequenceModel.SequenceModelBuilder;
import fpml.confirmation.SequenceModel.SequenceModelBuilderImpl;
import fpml.confirmation.SequenceModel.SequenceModelImpl;
import fpml.confirmation.meta.SequenceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group defining the element used for message sequencing
 * @version ${project.version}
 */
@RosettaDataType(value="SequenceModel", builder=SequenceModel.SequenceModelBuilderImpl.class, version="${project.version}")
public interface SequenceModel extends RosettaModelObject {

	SequenceModelMeta metaData = new SequenceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A numeric value that can be used to order messages with the same correlation identifier from the same sender.
	 */
	Integer getSequenceNumber();

	/*********************** Build Methods  ***********************/
	SequenceModel build();
	
	SequenceModel.SequenceModelBuilder toBuilder();
	
	static SequenceModel.SequenceModelBuilder builder() {
		return new SequenceModel.SequenceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SequenceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SequenceModel> getType() {
		return SequenceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SequenceModelBuilder extends SequenceModel, RosettaModelObjectBuilder {
		SequenceModel.SequenceModelBuilder setSequenceNumber(Integer sequenceNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		}
		

		SequenceModel.SequenceModelBuilder prune();
	}

	/*********************** Immutable Implementation of SequenceModel  ***********************/
	class SequenceModelImpl implements SequenceModel {
		private final Integer sequenceNumber;
		
		protected SequenceModelImpl(SequenceModel.SequenceModelBuilder builder) {
			this.sequenceNumber = builder.getSequenceNumber();
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		public SequenceModel build() {
			return this;
		}
		
		@Override
		public SequenceModel.SequenceModelBuilder toBuilder() {
			SequenceModel.SequenceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SequenceModel.SequenceModelBuilder builder) {
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SequenceModel _that = getType().cast(o);
		
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SequenceModel {" +
				"sequenceNumber=" + this.sequenceNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of SequenceModel  ***********************/
	class SequenceModelBuilderImpl implements SequenceModel.SequenceModelBuilder {
	
		protected Integer sequenceNumber;
	
		public SequenceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("sequenceNumber")
		public Integer getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		@RosettaAttribute("sequenceNumber")
		public SequenceModel.SequenceModelBuilder setSequenceNumber(Integer sequenceNumber) {
			this.sequenceNumber = sequenceNumber==null?null:sequenceNumber;
			return this;
		}
		
		@Override
		public SequenceModel build() {
			return new SequenceModel.SequenceModelImpl(this);
		}
		
		@Override
		public SequenceModel.SequenceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SequenceModel.SequenceModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSequenceNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SequenceModel.SequenceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SequenceModel.SequenceModelBuilder o = (SequenceModel.SequenceModelBuilder) other;
			
			
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SequenceModel _that = getType().cast(o);
		
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SequenceModelBuilder {" +
				"sequenceNumber=" + this.sequenceNumber +
			'}';
		}
	}
}
