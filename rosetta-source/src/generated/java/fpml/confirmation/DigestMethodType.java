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
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.DigestMethodType.DigestMethodTypeBuilder;
import fpml.confirmation.DigestMethodType.DigestMethodTypeBuilderImpl;
import fpml.confirmation.DigestMethodType.DigestMethodTypeImpl;
import fpml.confirmation.meta.DigestMethodTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DigestMethodType", builder=DigestMethodType.DigestMethodTypeBuilderImpl.class, version="${project.version}")
public interface DigestMethodType extends RosettaModelObject {

	DigestMethodTypeMeta metaData = new DigestMethodTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getAlgorithm();

	/*********************** Build Methods  ***********************/
	DigestMethodType build();
	
	DigestMethodType.DigestMethodTypeBuilder toBuilder();
	
	static DigestMethodType.DigestMethodTypeBuilder builder() {
		return new DigestMethodType.DigestMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigestMethodType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DigestMethodType> getType() {
		return DigestMethodType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigestMethodTypeBuilder extends DigestMethodType, RosettaModelObjectBuilder {
		DigestMethodType.DigestMethodTypeBuilder setAlgorithm(String algorithm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		}
		

		DigestMethodType.DigestMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of DigestMethodType  ***********************/
	class DigestMethodTypeImpl implements DigestMethodType {
		private final String algorithm;
		
		protected DigestMethodTypeImpl(DigestMethodType.DigestMethodTypeBuilder builder) {
			this.algorithm = builder.getAlgorithm();
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		public DigestMethodType build() {
			return this;
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder toBuilder() {
			DigestMethodType.DigestMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigestMethodType.DigestMethodTypeBuilder builder) {
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DigestMethodType _that = getType().cast(o);
		
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
			return "DigestMethodType {" +
				"algorithm=" + this.algorithm +
			'}';
		}
	}

	/*********************** Builder Implementation of DigestMethodType  ***********************/
	class DigestMethodTypeBuilderImpl implements DigestMethodType.DigestMethodTypeBuilder {
	
		protected String algorithm;
	
		public DigestMethodTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("algorithm")
		public DigestMethodType.DigestMethodTypeBuilder setAlgorithm(String algorithm) {
			this.algorithm = algorithm==null?null:algorithm;
			return this;
		}
		
		@Override
		public DigestMethodType build() {
			return new DigestMethodType.DigestMethodTypeImpl(this);
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlgorithm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DigestMethodType.DigestMethodTypeBuilder o = (DigestMethodType.DigestMethodTypeBuilder) other;
			
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DigestMethodType _that = getType().cast(o);
		
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
			return "DigestMethodTypeBuilder {" +
				"algorithm=" + this.algorithm +
			'}';
		}
	}
}
