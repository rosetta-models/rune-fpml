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
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.CanonicalizationMethodType.CanonicalizationMethodTypeBuilder;
import fpml.confirmation.CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl;
import fpml.confirmation.CanonicalizationMethodType.CanonicalizationMethodTypeImpl;
import fpml.confirmation.meta.CanonicalizationMethodTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CanonicalizationMethodType", builder=CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl.class, version="${project.version}")
public interface CanonicalizationMethodType extends RosettaModelObject {

	CanonicalizationMethodTypeMeta metaData = new CanonicalizationMethodTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getAlgorithm();

	/*********************** Build Methods  ***********************/
	CanonicalizationMethodType build();
	
	CanonicalizationMethodType.CanonicalizationMethodTypeBuilder toBuilder();
	
	static CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder() {
		return new CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CanonicalizationMethodType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CanonicalizationMethodType> getType() {
		return CanonicalizationMethodType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CanonicalizationMethodTypeBuilder extends CanonicalizationMethodType, RosettaModelObjectBuilder {
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CanonicalizationMethodType  ***********************/
	class CanonicalizationMethodTypeImpl implements CanonicalizationMethodType {
		private final String algorithm;
		
		protected CanonicalizationMethodTypeImpl(CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder) {
			this.algorithm = builder.getAlgorithm();
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		public CanonicalizationMethodType build() {
			return this;
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder toBuilder() {
			CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder) {
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CanonicalizationMethodType _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CanonicalizationMethodType {" +
				"algorithm=" + this.algorithm +
			'}';
		}
	}

	/*********************** Builder Implementation of CanonicalizationMethodType  ***********************/
	class CanonicalizationMethodTypeBuilderImpl implements CanonicalizationMethodType.CanonicalizationMethodTypeBuilder {
	
		protected String algorithm;
	
		public CanonicalizationMethodTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public CanonicalizationMethodType build() {
			return new CanonicalizationMethodType.CanonicalizationMethodTypeImpl(this);
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlgorithm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CanonicalizationMethodType.CanonicalizationMethodTypeBuilder o = (CanonicalizationMethodType.CanonicalizationMethodTypeBuilder) other;
			
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CanonicalizationMethodType _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CanonicalizationMethodTypeBuilder {" +
				"algorithm=" + this.algorithm +
			'}';
		}
	}
}
