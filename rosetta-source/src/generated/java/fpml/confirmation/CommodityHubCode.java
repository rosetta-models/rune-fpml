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
import fpml.confirmation.CommodityHubCode;
import fpml.confirmation.CommodityHubCode.CommodityHubCodeBuilder;
import fpml.confirmation.CommodityHubCode.CommodityHubCodeBuilderImpl;
import fpml.confirmation.CommodityHubCode.CommodityHubCodeImpl;
import fpml.confirmation.meta.CommodityHubCodeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A scheme identifying the code for a hub or other reference for a physically settled commodity trade.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityHubCode", builder=CommodityHubCode.CommodityHubCodeBuilderImpl.class, version="${project.version}")
public interface CommodityHubCode extends RosettaModelObject {

	CommodityHubCodeMeta metaData = new CommodityHubCodeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getHubCodeScheme();

	/*********************** Build Methods  ***********************/
	CommodityHubCode build();
	
	CommodityHubCode.CommodityHubCodeBuilder toBuilder();
	
	static CommodityHubCode.CommodityHubCodeBuilder builder() {
		return new CommodityHubCode.CommodityHubCodeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityHubCode> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityHubCode> getType() {
		return CommodityHubCode.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("hubCodeScheme"), String.class, getHubCodeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityHubCodeBuilder extends CommodityHubCode, RosettaModelObjectBuilder {
		CommodityHubCode.CommodityHubCodeBuilder setValue(String value);
		CommodityHubCode.CommodityHubCodeBuilder setHubCodeScheme(String hubCodeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("hubCodeScheme"), String.class, getHubCodeScheme(), this);
		}
		

		CommodityHubCode.CommodityHubCodeBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityHubCode  ***********************/
	class CommodityHubCodeImpl implements CommodityHubCode {
		private final String value;
		private final String hubCodeScheme;
		
		protected CommodityHubCodeImpl(CommodityHubCode.CommodityHubCodeBuilder builder) {
			this.value = builder.getValue();
			this.hubCodeScheme = builder.getHubCodeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("hubCodeScheme")
		public String getHubCodeScheme() {
			return hubCodeScheme;
		}
		
		@Override
		public CommodityHubCode build() {
			return this;
		}
		
		@Override
		public CommodityHubCode.CommodityHubCodeBuilder toBuilder() {
			CommodityHubCode.CommodityHubCodeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityHubCode.CommodityHubCodeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getHubCodeScheme()).ifPresent(builder::setHubCodeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityHubCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(hubCodeScheme, _that.getHubCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (hubCodeScheme != null ? hubCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityHubCode {" +
				"value=" + this.value + ", " +
				"hubCodeScheme=" + this.hubCodeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityHubCode  ***********************/
	class CommodityHubCodeBuilderImpl implements CommodityHubCode.CommodityHubCodeBuilder {
	
		protected String value;
		protected String hubCodeScheme;
	
		public CommodityHubCodeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("hubCodeScheme")
		public String getHubCodeScheme() {
			return hubCodeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CommodityHubCode.CommodityHubCodeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("hubCodeScheme")
		public CommodityHubCode.CommodityHubCodeBuilder setHubCodeScheme(String hubCodeScheme) {
			this.hubCodeScheme = hubCodeScheme==null?null:hubCodeScheme;
			return this;
		}
		
		@Override
		public CommodityHubCode build() {
			return new CommodityHubCode.CommodityHubCodeImpl(this);
		}
		
		@Override
		public CommodityHubCode.CommodityHubCodeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityHubCode.CommodityHubCodeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getHubCodeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityHubCode.CommodityHubCodeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityHubCode.CommodityHubCodeBuilder o = (CommodityHubCode.CommodityHubCodeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getHubCodeScheme(), o.getHubCodeScheme(), this::setHubCodeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityHubCode _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(hubCodeScheme, _that.getHubCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (hubCodeScheme != null ? hubCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityHubCodeBuilder {" +
				"value=" + this.value + ", " +
				"hubCodeScheme=" + this.hubCodeScheme +
			'}';
		}
	}
}
