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
import fpml.confirmation.CommodityProductGrade;
import fpml.confirmation.CommodityProductGrade.CommodityProductGradeBuilder;
import fpml.confirmation.CommodityProductGrade.CommodityProductGradeBuilderImpl;
import fpml.confirmation.CommodityProductGrade.CommodityProductGradeImpl;
import fpml.confirmation.meta.CommodityProductGradeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the grade of physical commodity product to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityProductGrade", builder=CommodityProductGrade.CommodityProductGradeBuilderImpl.class, version="${project.version}")
public interface CommodityProductGrade extends RosettaModelObject {

	CommodityProductGradeMeta metaData = new CommodityProductGradeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getProductGradeScheme();

	/*********************** Build Methods  ***********************/
	CommodityProductGrade build();
	
	CommodityProductGrade.CommodityProductGradeBuilder toBuilder();
	
	static CommodityProductGrade.CommodityProductGradeBuilder builder() {
		return new CommodityProductGrade.CommodityProductGradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityProductGrade> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityProductGrade> getType() {
		return CommodityProductGrade.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("productGradeScheme"), String.class, getProductGradeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityProductGradeBuilder extends CommodityProductGrade, RosettaModelObjectBuilder {
		CommodityProductGrade.CommodityProductGradeBuilder setValue(String value);
		CommodityProductGrade.CommodityProductGradeBuilder setProductGradeScheme(String productGradeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("productGradeScheme"), String.class, getProductGradeScheme(), this);
		}
		

		CommodityProductGrade.CommodityProductGradeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityProductGrade  ***********************/
	class CommodityProductGradeImpl implements CommodityProductGrade {
		private final String value;
		private final String productGradeScheme;
		
		protected CommodityProductGradeImpl(CommodityProductGrade.CommodityProductGradeBuilder builder) {
			this.value = builder.getValue();
			this.productGradeScheme = builder.getProductGradeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productGradeScheme")
		public String getProductGradeScheme() {
			return productGradeScheme;
		}
		
		@Override
		public CommodityProductGrade build() {
			return this;
		}
		
		@Override
		public CommodityProductGrade.CommodityProductGradeBuilder toBuilder() {
			CommodityProductGrade.CommodityProductGradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityProductGrade.CommodityProductGradeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getProductGradeScheme()).ifPresent(builder::setProductGradeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductGrade _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productGradeScheme, _that.getProductGradeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productGradeScheme != null ? productGradeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductGrade {" +
				"value=" + this.value + ", " +
				"productGradeScheme=" + this.productGradeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityProductGrade  ***********************/
	class CommodityProductGradeBuilderImpl implements CommodityProductGrade.CommodityProductGradeBuilder {
	
		protected String value;
		protected String productGradeScheme;
	
		public CommodityProductGradeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("productGradeScheme")
		public String getProductGradeScheme() {
			return productGradeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityProductGrade.CommodityProductGradeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("productGradeScheme")
		public CommodityProductGrade.CommodityProductGradeBuilder setProductGradeScheme(String productGradeScheme) {
			this.productGradeScheme = productGradeScheme==null?null:productGradeScheme;
			return this;
		}
		
		@Override
		public CommodityProductGrade build() {
			return new CommodityProductGrade.CommodityProductGradeImpl(this);
		}
		
		@Override
		public CommodityProductGrade.CommodityProductGradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductGrade.CommodityProductGradeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getProductGradeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductGrade.CommodityProductGradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityProductGrade.CommodityProductGradeBuilder o = (CommodityProductGrade.CommodityProductGradeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getProductGradeScheme(), o.getProductGradeScheme(), this::setProductGradeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductGrade _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(productGradeScheme, _that.getProductGradeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (productGradeScheme != null ? productGradeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductGradeBuilder {" +
				"value=" + this.value + ", " +
				"productGradeScheme=" + this.productGradeScheme +
			'}';
		}
	}
}
