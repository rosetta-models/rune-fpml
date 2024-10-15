package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ObjectTypeSequence;
import fpml.confirmation.ObjectTypeSequence.ObjectTypeSequenceBuilder;
import fpml.confirmation.ObjectTypeSequence.ObjectTypeSequenceBuilderImpl;
import fpml.confirmation.ObjectTypeSequence.ObjectTypeSequenceImpl;
import fpml.confirmation.meta.ObjectTypeSequenceMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="ObjectTypeSequence", builder=ObjectTypeSequence.ObjectTypeSequenceBuilderImpl.class, version="${project.version}")
public interface ObjectTypeSequence extends RosettaModelObject {

	ObjectTypeSequenceMeta metaData = new ObjectTypeSequenceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ObjectTypeSequence build();
	
	ObjectTypeSequence.ObjectTypeSequenceBuilder toBuilder();
	
	static ObjectTypeSequence.ObjectTypeSequenceBuilder builder() {
		return new ObjectTypeSequence.ObjectTypeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObjectTypeSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ObjectTypeSequence> getType() {
		return ObjectTypeSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObjectTypeSequenceBuilder extends ObjectTypeSequence, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ObjectTypeSequence.ObjectTypeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of ObjectTypeSequence  ***********************/
	class ObjectTypeSequenceImpl implements ObjectTypeSequence {
		
		protected ObjectTypeSequenceImpl(ObjectTypeSequence.ObjectTypeSequenceBuilder builder) {
		}
		
		@Override
		public ObjectTypeSequence build() {
			return this;
		}
		
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder toBuilder() {
			ObjectTypeSequence.ObjectTypeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObjectTypeSequence.ObjectTypeSequenceBuilder builder) {
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectTypeSequence {" +
			'}';
		}
	}

	/*********************** Builder Implementation of ObjectTypeSequence  ***********************/
	class ObjectTypeSequenceBuilderImpl implements ObjectTypeSequence.ObjectTypeSequenceBuilder {
	
	
		public ObjectTypeSequenceBuilderImpl() {
		}
	
		
		@Override
		public ObjectTypeSequence build() {
			return new ObjectTypeSequence.ObjectTypeSequenceImpl(this);
		}
		
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObjectTypeSequence.ObjectTypeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObjectTypeSequence.ObjectTypeSequenceBuilder o = (ObjectTypeSequence.ObjectTypeSequenceBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObjectTypeSequenceBuilder {" +
			'}';
		}
	}
}
