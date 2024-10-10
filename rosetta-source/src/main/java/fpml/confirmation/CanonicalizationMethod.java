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
import fpml.confirmation.CanonicalizationMethod;
import fpml.confirmation.CanonicalizationMethod.CanonicalizationMethodBuilder;
import fpml.confirmation.CanonicalizationMethod.CanonicalizationMethodBuilderImpl;
import fpml.confirmation.CanonicalizationMethod.CanonicalizationMethodImpl;
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.CanonicalizationMethodType.CanonicalizationMethodTypeBuilder;
import fpml.confirmation.CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl;
import fpml.confirmation.CanonicalizationMethodType.CanonicalizationMethodTypeImpl;
import fpml.confirmation.meta.CanonicalizationMethodMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="CanonicalizationMethod", builder=CanonicalizationMethod.CanonicalizationMethodBuilderImpl.class, version="${project.version}")
public interface CanonicalizationMethod extends CanonicalizationMethodType {

	CanonicalizationMethodMeta metaData = new CanonicalizationMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CanonicalizationMethod build();
	
	CanonicalizationMethod.CanonicalizationMethodBuilder toBuilder();
	
	static CanonicalizationMethod.CanonicalizationMethodBuilder builder() {
		return new CanonicalizationMethod.CanonicalizationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CanonicalizationMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CanonicalizationMethod> getType() {
		return CanonicalizationMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CanonicalizationMethodBuilder extends CanonicalizationMethod, CanonicalizationMethodType.CanonicalizationMethodTypeBuilder {
		CanonicalizationMethod.CanonicalizationMethodBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		CanonicalizationMethod.CanonicalizationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of CanonicalizationMethod  ***********************/
	class CanonicalizationMethodImpl extends CanonicalizationMethodType.CanonicalizationMethodTypeImpl implements CanonicalizationMethod {
		
		protected CanonicalizationMethodImpl(CanonicalizationMethod.CanonicalizationMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public CanonicalizationMethod build() {
			return this;
		}
		
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder toBuilder() {
			CanonicalizationMethod.CanonicalizationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CanonicalizationMethod.CanonicalizationMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CanonicalizationMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CanonicalizationMethod  ***********************/
	class CanonicalizationMethodBuilderImpl extends CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl  implements CanonicalizationMethod.CanonicalizationMethodBuilder {
	
	
		public CanonicalizationMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("algorithm")
		public CanonicalizationMethod.CanonicalizationMethodBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public CanonicalizationMethod build() {
			return new CanonicalizationMethod.CanonicalizationMethodImpl(this);
		}
		
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CanonicalizationMethod.CanonicalizationMethodBuilder o = (CanonicalizationMethod.CanonicalizationMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CanonicalizationMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
