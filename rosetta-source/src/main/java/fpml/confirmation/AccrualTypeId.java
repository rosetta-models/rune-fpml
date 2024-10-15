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
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.AccrualTypeId.AccrualTypeIdBuilder;
import fpml.confirmation.AccrualTypeId.AccrualTypeIdBuilderImpl;
import fpml.confirmation.AccrualTypeId.AccrualTypeIdImpl;
import fpml.confirmation.meta.AccrualTypeIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure used to uniquely identify a single accrual type within a syndicated loan structure.
 * @version ${project.version}
 */
@RosettaDataType(value="AccrualTypeId", builder=AccrualTypeId.AccrualTypeIdBuilderImpl.class, version="${project.version}")
public interface AccrualTypeId extends RosettaModelObject {

	AccrualTypeIdMeta metaData = new AccrualTypeIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getAccrualTypeIdScheme();

	/*********************** Build Methods  ***********************/
	AccrualTypeId build();
	
	AccrualTypeId.AccrualTypeIdBuilder toBuilder();
	
	static AccrualTypeId.AccrualTypeIdBuilder builder() {
		return new AccrualTypeId.AccrualTypeIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccrualTypeId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccrualTypeId> getType() {
		return AccrualTypeId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accrualTypeIdScheme"), String.class, getAccrualTypeIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccrualTypeIdBuilder extends AccrualTypeId, RosettaModelObjectBuilder {
		AccrualTypeId.AccrualTypeIdBuilder setValue(String value);
		AccrualTypeId.AccrualTypeIdBuilder setAccrualTypeIdScheme(String accrualTypeIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accrualTypeIdScheme"), String.class, getAccrualTypeIdScheme(), this);
		}
		

		AccrualTypeId.AccrualTypeIdBuilder prune();
	}

	/*********************** Immutable Implementation of AccrualTypeId  ***********************/
	class AccrualTypeIdImpl implements AccrualTypeId {
		private final String value;
		private final String accrualTypeIdScheme;
		
		protected AccrualTypeIdImpl(AccrualTypeId.AccrualTypeIdBuilder builder) {
			this.value = builder.getValue();
			this.accrualTypeIdScheme = builder.getAccrualTypeIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accrualTypeIdScheme")
		public String getAccrualTypeIdScheme() {
			return accrualTypeIdScheme;
		}
		
		@Override
		public AccrualTypeId build() {
			return this;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder toBuilder() {
			AccrualTypeId.AccrualTypeIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccrualTypeId.AccrualTypeIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccrualTypeIdScheme()).ifPresent(builder::setAccrualTypeIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accrualTypeIdScheme, _that.getAccrualTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accrualTypeIdScheme != null ? accrualTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualTypeId {" +
				"value=" + this.value + ", " +
				"accrualTypeIdScheme=" + this.accrualTypeIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccrualTypeId  ***********************/
	class AccrualTypeIdBuilderImpl implements AccrualTypeId.AccrualTypeIdBuilder {
	
		protected String value;
		protected String accrualTypeIdScheme;
	
		public AccrualTypeIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accrualTypeIdScheme")
		public String getAccrualTypeIdScheme() {
			return accrualTypeIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public AccrualTypeId.AccrualTypeIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("accrualTypeIdScheme")
		public AccrualTypeId.AccrualTypeIdBuilder setAccrualTypeIdScheme(String accrualTypeIdScheme) {
			this.accrualTypeIdScheme = accrualTypeIdScheme==null?null:accrualTypeIdScheme;
			return this;
		}
		
		@Override
		public AccrualTypeId build() {
			return new AccrualTypeId.AccrualTypeIdImpl(this);
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccrualTypeIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccrualTypeId.AccrualTypeIdBuilder o = (AccrualTypeId.AccrualTypeIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccrualTypeIdScheme(), o.getAccrualTypeIdScheme(), this::setAccrualTypeIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccrualTypeId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accrualTypeIdScheme, _that.getAccrualTypeIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accrualTypeIdScheme != null ? accrualTypeIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccrualTypeIdBuilder {" +
				"value=" + this.value + ", " +
				"accrualTypeIdScheme=" + this.accrualTypeIdScheme +
			'}';
		}
	}
}
