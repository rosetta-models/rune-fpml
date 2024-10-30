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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FirstPeriodStartDate;
import fpml.confirmation.FirstPeriodStartDate.FirstPeriodStartDateBuilder;
import fpml.confirmation.FirstPeriodStartDate.FirstPeriodStartDateBuilderImpl;
import fpml.confirmation.FirstPeriodStartDate.FirstPeriodStartDateImpl;
import fpml.confirmation.meta.FirstPeriodStartDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FirstPeriodStartDate", builder=FirstPeriodStartDate.FirstPeriodStartDateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FirstPeriodStartDate extends RosettaModelObject {

	FirstPeriodStartDateMeta metaData = new FirstPeriodStartDateMeta();

	/*********************** Getter Methods  ***********************/
	Date getValue();
	String getHref();

	/*********************** Build Methods  ***********************/
	FirstPeriodStartDate build();
	
	FirstPeriodStartDate.FirstPeriodStartDateBuilder toBuilder();
	
	static FirstPeriodStartDate.FirstPeriodStartDateBuilder builder() {
		return new FirstPeriodStartDate.FirstPeriodStartDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FirstPeriodStartDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FirstPeriodStartDate> getType() {
		return FirstPeriodStartDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FirstPeriodStartDateBuilder extends FirstPeriodStartDate, RosettaModelObjectBuilder {
		FirstPeriodStartDate.FirstPeriodStartDateBuilder setValue(Date value);
		FirstPeriodStartDate.FirstPeriodStartDateBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), Date.class, getValue(), this);
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FirstPeriodStartDate.FirstPeriodStartDateBuilder prune();
	}

	/*********************** Immutable Implementation of FirstPeriodStartDate  ***********************/
	class FirstPeriodStartDateImpl implements FirstPeriodStartDate {
		private final Date value;
		private final String href;
		
		protected FirstPeriodStartDateImpl(FirstPeriodStartDate.FirstPeriodStartDateBuilder builder) {
			this.value = builder.getValue();
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("value")
		public Date getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FirstPeriodStartDate build() {
			return this;
		}
		
		@Override
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder toBuilder() {
			FirstPeriodStartDate.FirstPeriodStartDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FirstPeriodStartDate.FirstPeriodStartDateBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FirstPeriodStartDate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FirstPeriodStartDate {" +
				"value=" + this.value + ", " +
				"href=" + this.href +
			'}';
		}
	}

	/*********************** Builder Implementation of FirstPeriodStartDate  ***********************/
	class FirstPeriodStartDateBuilderImpl implements FirstPeriodStartDate.FirstPeriodStartDateBuilder {
	
		protected Date value;
		protected String href;
	
		public FirstPeriodStartDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public Date getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("value")
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder setValue(Date value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("href")
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FirstPeriodStartDate build() {
			return new FirstPeriodStartDate.FirstPeriodStartDateImpl(this);
		}
		
		@Override
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FirstPeriodStartDate.FirstPeriodStartDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FirstPeriodStartDate.FirstPeriodStartDateBuilder o = (FirstPeriodStartDate.FirstPeriodStartDateBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FirstPeriodStartDate _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FirstPeriodStartDateBuilder {" +
				"value=" + this.value + ", " +
				"href=" + this.href +
			'}';
		}
	}
}
