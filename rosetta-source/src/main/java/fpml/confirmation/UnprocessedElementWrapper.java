package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.UnprocessedElementWrapper;
import fpml.confirmation.UnprocessedElementWrapper.UnprocessedElementWrapperBuilder;
import fpml.confirmation.UnprocessedElementWrapper.UnprocessedElementWrapperBuilderImpl;
import fpml.confirmation.UnprocessedElementWrapper.UnprocessedElementWrapperImpl;
import fpml.confirmation.meta.UnprocessedElementWrapperMeta;


/**
 * A type holding a structure that is unvalidated
 * @version ${project.version}
 */
@RosettaDataType(value="UnprocessedElementWrapper", builder=UnprocessedElementWrapper.UnprocessedElementWrapperBuilderImpl.class, version="${project.version}")
public interface UnprocessedElementWrapper extends RosettaModelObject {

	UnprocessedElementWrapperMeta metaData = new UnprocessedElementWrapperMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	UnprocessedElementWrapper build();
	
	UnprocessedElementWrapper.UnprocessedElementWrapperBuilder toBuilder();
	
	static UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder() {
		return new UnprocessedElementWrapper.UnprocessedElementWrapperBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnprocessedElementWrapper> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnprocessedElementWrapper> getType() {
		return UnprocessedElementWrapper.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnprocessedElementWrapperBuilder extends UnprocessedElementWrapper, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder prune();
	}

	/*********************** Immutable Implementation of UnprocessedElementWrapper  ***********************/
	class UnprocessedElementWrapperImpl implements UnprocessedElementWrapper {
		
		protected UnprocessedElementWrapperImpl(UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder) {
		}
		
		@Override
		public UnprocessedElementWrapper build() {
			return this;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder toBuilder() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnprocessedElementWrapper.UnprocessedElementWrapperBuilder builder) {
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
			return "UnprocessedElementWrapper {" +
			'}';
		}
	}

	/*********************** Builder Implementation of UnprocessedElementWrapper  ***********************/
	class UnprocessedElementWrapperBuilderImpl implements UnprocessedElementWrapper.UnprocessedElementWrapperBuilder {
	
	
		public UnprocessedElementWrapperBuilderImpl() {
		}
	
		
		@Override
		public UnprocessedElementWrapper build() {
			return new UnprocessedElementWrapper.UnprocessedElementWrapperImpl(this);
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder o = (UnprocessedElementWrapper.UnprocessedElementWrapperBuilder) other;
			
			
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
			return "UnprocessedElementWrapperBuilder {" +
			'}';
		}
	}
}
