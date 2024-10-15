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
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.BusinessCenter.BusinessCenterBuilder;
import fpml.confirmation.BusinessCenter.BusinessCenterBuilderImpl;
import fpml.confirmation.BusinessCenter.BusinessCenterImpl;
import fpml.confirmation.meta.BusinessCenterMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location scheme.
 * @version ${project.version}
 */
@RosettaDataType(value="BusinessCenter", builder=BusinessCenter.BusinessCenterBuilderImpl.class, version="${project.version}")
public interface BusinessCenter extends RosettaModelObject {

	BusinessCenterMeta metaData = new BusinessCenterMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getBusinessCenterScheme();
	String getId();

	/*********************** Build Methods  ***********************/
	BusinessCenter build();
	
	BusinessCenter.BusinessCenterBuilder toBuilder();
	
	static BusinessCenter.BusinessCenterBuilder builder() {
		return new BusinessCenter.BusinessCenterBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCenter> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BusinessCenter> getType() {
		return BusinessCenter.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("businessCenterScheme"), String.class, getBusinessCenterScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCenterBuilder extends BusinessCenter, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder setValue(String value);
		BusinessCenter.BusinessCenterBuilder setBusinessCenterScheme(String businessCenterScheme);
		BusinessCenter.BusinessCenterBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("businessCenterScheme"), String.class, getBusinessCenterScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BusinessCenter.BusinessCenterBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCenter  ***********************/
	class BusinessCenterImpl implements BusinessCenter {
		private final String value;
		private final String businessCenterScheme;
		private final String id;
		
		protected BusinessCenterImpl(BusinessCenter.BusinessCenterBuilder builder) {
			this.value = builder.getValue();
			this.businessCenterScheme = builder.getBusinessCenterScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("businessCenterScheme")
		public String getBusinessCenterScheme() {
			return businessCenterScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BusinessCenter build() {
			return this;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder toBuilder() {
			BusinessCenter.BusinessCenterBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenter.BusinessCenterBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBusinessCenterScheme()).ifPresent(builder::setBusinessCenterScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenter _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(businessCenterScheme, _that.getBusinessCenterScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (businessCenterScheme != null ? businessCenterScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenter {" +
				"value=" + this.value + ", " +
				"businessCenterScheme=" + this.businessCenterScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessCenter  ***********************/
	class BusinessCenterBuilderImpl implements BusinessCenter.BusinessCenterBuilder {
	
		protected String value;
		protected String businessCenterScheme;
		protected String id;
	
		public BusinessCenterBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("businessCenterScheme")
		public String getBusinessCenterScheme() {
			return businessCenterScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public BusinessCenter.BusinessCenterBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("businessCenterScheme")
		public BusinessCenter.BusinessCenterBuilder setBusinessCenterScheme(String businessCenterScheme) {
			this.businessCenterScheme = businessCenterScheme==null?null:businessCenterScheme;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BusinessCenter.BusinessCenterBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BusinessCenter build() {
			return new BusinessCenter.BusinessCenterImpl(this);
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenter.BusinessCenterBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBusinessCenterScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenter.BusinessCenterBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenter.BusinessCenterBuilder o = (BusinessCenter.BusinessCenterBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBusinessCenterScheme(), o.getBusinessCenterScheme(), this::setBusinessCenterScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenter _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(businessCenterScheme, _that.getBusinessCenterScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (businessCenterScheme != null ? businessCenterScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenterBuilder {" +
				"value=" + this.value + ", " +
				"businessCenterScheme=" + this.businessCenterScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
