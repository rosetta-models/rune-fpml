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
import fpml.confirmation.MatrixTerm;
import fpml.confirmation.MatrixTerm.MatrixTermBuilder;
import fpml.confirmation.MatrixTerm.MatrixTermBuilderImpl;
import fpml.confirmation.MatrixTerm.MatrixTermImpl;
import fpml.confirmation.meta.MatrixTermMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MatrixTerm", builder=MatrixTerm.MatrixTermBuilderImpl.class, version="${project.version}")
public interface MatrixTerm extends RosettaModelObject {

	MatrixTermMeta metaData = new MatrixTermMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMatrixTermScheme();

	/*********************** Build Methods  ***********************/
	MatrixTerm build();
	
	MatrixTerm.MatrixTermBuilder toBuilder();
	
	static MatrixTerm.MatrixTermBuilder builder() {
		return new MatrixTerm.MatrixTermBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MatrixTerm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MatrixTerm> getType() {
		return MatrixTerm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("matrixTermScheme"), String.class, getMatrixTermScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MatrixTermBuilder extends MatrixTerm, RosettaModelObjectBuilder {
		MatrixTerm.MatrixTermBuilder setValue(String value);
		MatrixTerm.MatrixTermBuilder setMatrixTermScheme(String matrixTermScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("matrixTermScheme"), String.class, getMatrixTermScheme(), this);
		}
		

		MatrixTerm.MatrixTermBuilder prune();
	}

	/*********************** Immutable Implementation of MatrixTerm  ***********************/
	class MatrixTermImpl implements MatrixTerm {
		private final String value;
		private final String matrixTermScheme;
		
		protected MatrixTermImpl(MatrixTerm.MatrixTermBuilder builder) {
			this.value = builder.getValue();
			this.matrixTermScheme = builder.getMatrixTermScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("matrixTermScheme")
		public String getMatrixTermScheme() {
			return matrixTermScheme;
		}
		
		@Override
		public MatrixTerm build() {
			return this;
		}
		
		@Override
		public MatrixTerm.MatrixTermBuilder toBuilder() {
			MatrixTerm.MatrixTermBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MatrixTerm.MatrixTermBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMatrixTermScheme()).ifPresent(builder::setMatrixTermScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixTerm _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(matrixTermScheme, _that.getMatrixTermScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (matrixTermScheme != null ? matrixTermScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixTerm {" +
				"value=" + this.value + ", " +
				"matrixTermScheme=" + this.matrixTermScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MatrixTerm  ***********************/
	class MatrixTermBuilderImpl implements MatrixTerm.MatrixTermBuilder {
	
		protected String value;
		protected String matrixTermScheme;
	
		public MatrixTermBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("matrixTermScheme")
		public String getMatrixTermScheme() {
			return matrixTermScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MatrixTerm.MatrixTermBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("matrixTermScheme")
		public MatrixTerm.MatrixTermBuilder setMatrixTermScheme(String matrixTermScheme) {
			this.matrixTermScheme = matrixTermScheme==null?null:matrixTermScheme;
			return this;
		}
		
		@Override
		public MatrixTerm build() {
			return new MatrixTerm.MatrixTermImpl(this);
		}
		
		@Override
		public MatrixTerm.MatrixTermBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixTerm.MatrixTermBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMatrixTermScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixTerm.MatrixTermBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MatrixTerm.MatrixTermBuilder o = (MatrixTerm.MatrixTermBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMatrixTermScheme(), o.getMatrixTermScheme(), this::setMatrixTermScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixTerm _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(matrixTermScheme, _that.getMatrixTermScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (matrixTermScheme != null ? matrixTermScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixTermBuilder {" +
				"value=" + this.value + ", " +
				"matrixTermScheme=" + this.matrixTermScheme +
			'}';
		}
	}
}
