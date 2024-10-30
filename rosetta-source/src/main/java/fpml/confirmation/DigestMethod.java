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
import fpml.confirmation.DigestMethod;
import fpml.confirmation.DigestMethod.DigestMethodBuilder;
import fpml.confirmation.DigestMethod.DigestMethodBuilderImpl;
import fpml.confirmation.DigestMethod.DigestMethodImpl;
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.DigestMethodType.DigestMethodTypeBuilder;
import fpml.confirmation.DigestMethodType.DigestMethodTypeBuilderImpl;
import fpml.confirmation.DigestMethodType.DigestMethodTypeImpl;
import fpml.confirmation.meta.DigestMethodMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="DigestMethod", builder=DigestMethod.DigestMethodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface DigestMethod extends DigestMethodType {

	DigestMethodMeta metaData = new DigestMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DigestMethod build();
	
	DigestMethod.DigestMethodBuilder toBuilder();
	
	static DigestMethod.DigestMethodBuilder builder() {
		return new DigestMethod.DigestMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigestMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DigestMethod> getType() {
		return DigestMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigestMethodBuilder extends DigestMethod, DigestMethodType.DigestMethodTypeBuilder {
		DigestMethod.DigestMethodBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		DigestMethod.DigestMethodBuilder prune();
	}

	/*********************** Immutable Implementation of DigestMethod  ***********************/
	class DigestMethodImpl extends DigestMethodType.DigestMethodTypeImpl implements DigestMethod {
		
		protected DigestMethodImpl(DigestMethod.DigestMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public DigestMethod build() {
			return this;
		}
		
		@Override
		public DigestMethod.DigestMethodBuilder toBuilder() {
			DigestMethod.DigestMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigestMethod.DigestMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "DigestMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DigestMethod  ***********************/
	class DigestMethodBuilderImpl extends DigestMethodType.DigestMethodTypeBuilderImpl  implements DigestMethod.DigestMethodBuilder {
	
	
		public DigestMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("algorithm")
		public DigestMethod.DigestMethodBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public DigestMethod build() {
			return new DigestMethod.DigestMethodImpl(this);
		}
		
		@Override
		public DigestMethod.DigestMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethod.DigestMethodBuilder prune() {
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
		public DigestMethod.DigestMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DigestMethod.DigestMethodBuilder o = (DigestMethod.DigestMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "DigestMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
