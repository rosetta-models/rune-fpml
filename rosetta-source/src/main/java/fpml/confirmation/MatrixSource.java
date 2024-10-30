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
import fpml.confirmation.MatrixSource;
import fpml.confirmation.MatrixSource.MatrixSourceBuilder;
import fpml.confirmation.MatrixSource.MatrixSourceBuilderImpl;
import fpml.confirmation.MatrixSource.MatrixSourceImpl;
import fpml.confirmation.meta.MatrixSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="MatrixSource", builder=MatrixSource.MatrixSourceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface MatrixSource extends RosettaModelObject {

	MatrixSourceMeta metaData = new MatrixSourceMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getSettledEntityMatrixSourceScheme();

	/*********************** Build Methods  ***********************/
	MatrixSource build();
	
	MatrixSource.MatrixSourceBuilder toBuilder();
	
	static MatrixSource.MatrixSourceBuilder builder() {
		return new MatrixSource.MatrixSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MatrixSource> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MatrixSource> getType() {
		return MatrixSource.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settledEntityMatrixSourceScheme"), String.class, getSettledEntityMatrixSourceScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MatrixSourceBuilder extends MatrixSource, RosettaModelObjectBuilder {
		MatrixSource.MatrixSourceBuilder setValue(String value);
		MatrixSource.MatrixSourceBuilder setSettledEntityMatrixSourceScheme(String settledEntityMatrixSourceScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settledEntityMatrixSourceScheme"), String.class, getSettledEntityMatrixSourceScheme(), this);
		}
		

		MatrixSource.MatrixSourceBuilder prune();
	}

	/*********************** Immutable Implementation of MatrixSource  ***********************/
	class MatrixSourceImpl implements MatrixSource {
		private final String value;
		private final String settledEntityMatrixSourceScheme;
		
		protected MatrixSourceImpl(MatrixSource.MatrixSourceBuilder builder) {
			this.value = builder.getValue();
			this.settledEntityMatrixSourceScheme = builder.getSettledEntityMatrixSourceScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrixSourceScheme")
		public String getSettledEntityMatrixSourceScheme() {
			return settledEntityMatrixSourceScheme;
		}
		
		@Override
		public MatrixSource build() {
			return this;
		}
		
		@Override
		public MatrixSource.MatrixSourceBuilder toBuilder() {
			MatrixSource.MatrixSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MatrixSource.MatrixSourceBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettledEntityMatrixSourceScheme()).ifPresent(builder::setSettledEntityMatrixSourceScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settledEntityMatrixSourceScheme, _that.getSettledEntityMatrixSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrixSourceScheme != null ? settledEntityMatrixSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixSource {" +
				"value=" + this.value + ", " +
				"settledEntityMatrixSourceScheme=" + this.settledEntityMatrixSourceScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MatrixSource  ***********************/
	class MatrixSourceBuilderImpl implements MatrixSource.MatrixSourceBuilder {
	
		protected String value;
		protected String settledEntityMatrixSourceScheme;
	
		public MatrixSourceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrixSourceScheme")
		public String getSettledEntityMatrixSourceScheme() {
			return settledEntityMatrixSourceScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MatrixSource.MatrixSourceBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("settledEntityMatrixSourceScheme")
		public MatrixSource.MatrixSourceBuilder setSettledEntityMatrixSourceScheme(String settledEntityMatrixSourceScheme) {
			this.settledEntityMatrixSourceScheme = settledEntityMatrixSourceScheme==null?null:settledEntityMatrixSourceScheme;
			return this;
		}
		
		@Override
		public MatrixSource build() {
			return new MatrixSource.MatrixSourceImpl(this);
		}
		
		@Override
		public MatrixSource.MatrixSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixSource.MatrixSourceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettledEntityMatrixSourceScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixSource.MatrixSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MatrixSource.MatrixSourceBuilder o = (MatrixSource.MatrixSourceBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettledEntityMatrixSourceScheme(), o.getSettledEntityMatrixSourceScheme(), this::setSettledEntityMatrixSourceScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settledEntityMatrixSourceScheme, _that.getSettledEntityMatrixSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrixSourceScheme != null ? settledEntityMatrixSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixSourceBuilder {" +
				"value=" + this.value + ", " +
				"settledEntityMatrixSourceScheme=" + this.settledEntityMatrixSourceScheme +
			'}';
		}
	}
}
