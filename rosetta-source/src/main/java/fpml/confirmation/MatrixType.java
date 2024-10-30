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
import fpml.confirmation.MatrixType;
import fpml.confirmation.MatrixType.MatrixTypeBuilder;
import fpml.confirmation.MatrixType.MatrixTypeBuilderImpl;
import fpml.confirmation.MatrixType.MatrixTypeImpl;
import fpml.confirmation.meta.MatrixTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MatrixType", builder=MatrixType.MatrixTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MatrixType extends RosettaModelObject {

	MatrixTypeMeta metaData = new MatrixTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMatrixTypeScheme();

	/*********************** Build Methods  ***********************/
	MatrixType build();
	
	MatrixType.MatrixTypeBuilder toBuilder();
	
	static MatrixType.MatrixTypeBuilder builder() {
		return new MatrixType.MatrixTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MatrixType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MatrixType> getType() {
		return MatrixType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("matrixTypeScheme"), String.class, getMatrixTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MatrixTypeBuilder extends MatrixType, RosettaModelObjectBuilder {
		MatrixType.MatrixTypeBuilder setValue(String value);
		MatrixType.MatrixTypeBuilder setMatrixTypeScheme(String matrixTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("matrixTypeScheme"), String.class, getMatrixTypeScheme(), this);
		}
		

		MatrixType.MatrixTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MatrixType  ***********************/
	class MatrixTypeImpl implements MatrixType {
		private final String value;
		private final String matrixTypeScheme;
		
		protected MatrixTypeImpl(MatrixType.MatrixTypeBuilder builder) {
			this.value = builder.getValue();
			this.matrixTypeScheme = builder.getMatrixTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("matrixTypeScheme")
		public String getMatrixTypeScheme() {
			return matrixTypeScheme;
		}
		
		@Override
		public MatrixType build() {
			return this;
		}
		
		@Override
		public MatrixType.MatrixTypeBuilder toBuilder() {
			MatrixType.MatrixTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MatrixType.MatrixTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMatrixTypeScheme()).ifPresent(builder::setMatrixTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(matrixTypeScheme, _that.getMatrixTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (matrixTypeScheme != null ? matrixTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixType {" +
				"value=" + this.value + ", " +
				"matrixTypeScheme=" + this.matrixTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MatrixType  ***********************/
	class MatrixTypeBuilderImpl implements MatrixType.MatrixTypeBuilder {
	
		protected String value;
		protected String matrixTypeScheme;
	
		public MatrixTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("matrixTypeScheme")
		public String getMatrixTypeScheme() {
			return matrixTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MatrixType.MatrixTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("matrixTypeScheme")
		public MatrixType.MatrixTypeBuilder setMatrixTypeScheme(String matrixTypeScheme) {
			this.matrixTypeScheme = matrixTypeScheme==null?null:matrixTypeScheme;
			return this;
		}
		
		@Override
		public MatrixType build() {
			return new MatrixType.MatrixTypeImpl(this);
		}
		
		@Override
		public MatrixType.MatrixTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixType.MatrixTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMatrixTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixType.MatrixTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MatrixType.MatrixTypeBuilder o = (MatrixType.MatrixTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMatrixTypeScheme(), o.getMatrixTypeScheme(), this::setMatrixTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(matrixTypeScheme, _that.getMatrixTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (matrixTypeScheme != null ? matrixTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixTypeBuilder {" +
				"value=" + this.value + ", " +
				"matrixTypeScheme=" + this.matrixTypeScheme +
			'}';
		}
	}
}
