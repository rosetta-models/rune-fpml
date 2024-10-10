package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Math;
import fpml.confirmation.Math.MathBuilder;
import fpml.confirmation.Math.MathBuilderImpl;
import fpml.confirmation.Math.MathImpl;
import fpml.confirmation.meta.MathMeta;


/**
 * A type defining a mathematical expression.
 * @version ${project.version}
 */
@RosettaDataType(value="Math", builder=Math.MathBuilderImpl.class, version="${project.version}")
public interface Math extends RosettaModelObject {

	MathMeta metaData = new MathMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Math build();
	
	Math.MathBuilder toBuilder();
	
	static Math.MathBuilder builder() {
		return new Math.MathBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Math> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Math> getType() {
		return Math.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface MathBuilder extends Math, RosettaModelObjectBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		Math.MathBuilder prune();
	}

	/*********************** Immutable Implementation of Math  ***********************/
	class MathImpl implements Math {
		
		protected MathImpl(Math.MathBuilder builder) {
		}
		
		@Override
		public Math build() {
			return this;
		}
		
		@Override
		public Math.MathBuilder toBuilder() {
			Math.MathBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Math.MathBuilder builder) {
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
			return "Math {" +
			'}';
		}
	}

	/*********************** Builder Implementation of Math  ***********************/
	class MathBuilderImpl implements Math.MathBuilder {
	
	
		public MathBuilderImpl() {
		}
	
		
		@Override
		public Math build() {
			return new Math.MathImpl(this);
		}
		
		@Override
		public Math.MathBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Math.MathBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Math.MathBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Math.MathBuilder o = (Math.MathBuilder) other;
			
			
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
			return "MathBuilder {" +
			'}';
		}
	}
}
