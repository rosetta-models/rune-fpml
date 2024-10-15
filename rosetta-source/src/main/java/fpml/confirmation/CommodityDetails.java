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
import fpml.confirmation.CommodityDetails;
import fpml.confirmation.CommodityDetails.CommodityDetailsBuilder;
import fpml.confirmation.CommodityDetails.CommodityDetailsBuilderImpl;
import fpml.confirmation.CommodityDetails.CommodityDetailsImpl;
import fpml.confirmation.meta.CommodityDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityDetails", builder=CommodityDetails.CommodityDetailsBuilderImpl.class, version="${project.version}")
public interface CommodityDetails extends RosettaModelObject {

	CommodityDetailsMeta metaData = new CommodityDetailsMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCommodityDetailsScheme();

	/*********************** Build Methods  ***********************/
	CommodityDetails build();
	
	CommodityDetails.CommodityDetailsBuilder toBuilder();
	
	static CommodityDetails.CommodityDetailsBuilder builder() {
		return new CommodityDetails.CommodityDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityDetails> getType() {
		return CommodityDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("commodityDetailsScheme"), String.class, getCommodityDetailsScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDetailsBuilder extends CommodityDetails, RosettaModelObjectBuilder {
		CommodityDetails.CommodityDetailsBuilder setValue(String value);
		CommodityDetails.CommodityDetailsBuilder setCommodityDetailsScheme(String commodityDetailsScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("commodityDetailsScheme"), String.class, getCommodityDetailsScheme(), this);
		}
		

		CommodityDetails.CommodityDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDetails  ***********************/
	class CommodityDetailsImpl implements CommodityDetails {
		private final String value;
		private final String commodityDetailsScheme;
		
		protected CommodityDetailsImpl(CommodityDetails.CommodityDetailsBuilder builder) {
			this.value = builder.getValue();
			this.commodityDetailsScheme = builder.getCommodityDetailsScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityDetailsScheme")
		public String getCommodityDetailsScheme() {
			return commodityDetailsScheme;
		}
		
		@Override
		public CommodityDetails build() {
			return this;
		}
		
		@Override
		public CommodityDetails.CommodityDetailsBuilder toBuilder() {
			CommodityDetails.CommodityDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDetails.CommodityDetailsBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCommodityDetailsScheme()).ifPresent(builder::setCommodityDetailsScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDetails _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityDetailsScheme, _that.getCommodityDetailsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityDetailsScheme != null ? commodityDetailsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDetails {" +
				"value=" + this.value + ", " +
				"commodityDetailsScheme=" + this.commodityDetailsScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityDetails  ***********************/
	class CommodityDetailsBuilderImpl implements CommodityDetails.CommodityDetailsBuilder {
	
		protected String value;
		protected String commodityDetailsScheme;
	
		public CommodityDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("commodityDetailsScheme")
		public String getCommodityDetailsScheme() {
			return commodityDetailsScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityDetails.CommodityDetailsBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("commodityDetailsScheme")
		public CommodityDetails.CommodityDetailsBuilder setCommodityDetailsScheme(String commodityDetailsScheme) {
			this.commodityDetailsScheme = commodityDetailsScheme==null?null:commodityDetailsScheme;
			return this;
		}
		
		@Override
		public CommodityDetails build() {
			return new CommodityDetails.CommodityDetailsImpl(this);
		}
		
		@Override
		public CommodityDetails.CommodityDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDetails.CommodityDetailsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCommodityDetailsScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDetails.CommodityDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityDetails.CommodityDetailsBuilder o = (CommodityDetails.CommodityDetailsBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCommodityDetailsScheme(), o.getCommodityDetailsScheme(), this::setCommodityDetailsScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityDetails _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(commodityDetailsScheme, _that.getCommodityDetailsScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (commodityDetailsScheme != null ? commodityDetailsScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDetailsBuilder {" +
				"value=" + this.value + ", " +
				"commodityDetailsScheme=" + this.commodityDetailsScheme +
			'}';
		}
	}
}
