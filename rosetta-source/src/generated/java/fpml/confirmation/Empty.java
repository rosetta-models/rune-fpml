package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Empty;
import fpml.confirmation.Empty.EmptyBuilder;
import fpml.confirmation.Empty.EmptyBuilderImpl;
import fpml.confirmation.Empty.EmptyImpl;
import fpml.confirmation.meta.EmptyMeta;


/**
 * A special type meant to be used for elements with no content and no attributes.
 * @version ${project.version}
 */
@RosettaDataType(value="Empty", builder=Empty.EmptyBuilderImpl.class, version="${project.version}")
public interface Empty extends RosettaModelObject {

	EmptyMeta metaData = new EmptyMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Empty build();
	
	Empty.EmptyBuilder toBuilder();
	
	static Empty.EmptyBuilder builder() {
		return new Empty.EmptyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Empty> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Empty> getType() {
		return Empty.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface EmptyBuilder extends Empty, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		Empty.EmptyBuilder prune();
	}

	/*********************** Immutable Implementation of Empty  ***********************/
	class EmptyImpl implements Empty {
		
		protected EmptyImpl(Empty.EmptyBuilder builder) {
		}
		
		@Override
		public Empty build() {
			return this;
		}
		
		@Override
		public Empty.EmptyBuilder toBuilder() {
			Empty.EmptyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Empty.EmptyBuilder builder) {
		}

		@Override
		public boolean equals(java.lang.Object o) {
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
			return "Empty {" +
			'}';
		}
	}

	/*********************** Builder Implementation of Empty  ***********************/
	class EmptyBuilderImpl implements Empty.EmptyBuilder {
	
	
		public EmptyBuilderImpl() {
		}
	
		
		@Override
		public Empty build() {
			return new Empty.EmptyImpl(this);
		}
		
		@Override
		public Empty.EmptyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Empty.EmptyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Empty.EmptyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Empty.EmptyBuilder o = (Empty.EmptyBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
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
			return "EmptyBuilder {" +
			'}';
		}
	}
}
