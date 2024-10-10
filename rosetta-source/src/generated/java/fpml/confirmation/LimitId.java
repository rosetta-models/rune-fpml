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
import fpml.confirmation.LimitId;
import fpml.confirmation.LimitId.LimitIdBuilder;
import fpml.confirmation.LimitId.LimitIdBuilderImpl;
import fpml.confirmation.LimitId.LimitIdImpl;
import fpml.confirmation.meta.LimitIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LimitId", builder=LimitId.LimitIdBuilderImpl.class, version="${project.version}")
public interface LimitId extends RosettaModelObject {

	LimitIdMeta metaData = new LimitIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCreditLimitIdScheme();

	/*********************** Build Methods  ***********************/
	LimitId build();
	
	LimitId.LimitIdBuilder toBuilder();
	
	static LimitId.LimitIdBuilder builder() {
		return new LimitId.LimitIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LimitId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LimitId> getType() {
		return LimitId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditLimitIdScheme"), String.class, getCreditLimitIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LimitIdBuilder extends LimitId, RosettaModelObjectBuilder {
		LimitId.LimitIdBuilder setValue(String value);
		LimitId.LimitIdBuilder setCreditLimitIdScheme(String creditLimitIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditLimitIdScheme"), String.class, getCreditLimitIdScheme(), this);
		}
		

		LimitId.LimitIdBuilder prune();
	}

	/*********************** Immutable Implementation of LimitId  ***********************/
	class LimitIdImpl implements LimitId {
		private final String value;
		private final String creditLimitIdScheme;
		
		protected LimitIdImpl(LimitId.LimitIdBuilder builder) {
			this.value = builder.getValue();
			this.creditLimitIdScheme = builder.getCreditLimitIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditLimitIdScheme")
		public String getCreditLimitIdScheme() {
			return creditLimitIdScheme;
		}
		
		@Override
		public LimitId build() {
			return this;
		}
		
		@Override
		public LimitId.LimitIdBuilder toBuilder() {
			LimitId.LimitIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitId.LimitIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditLimitIdScheme()).ifPresent(builder::setCreditLimitIdScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditLimitIdScheme, _that.getCreditLimitIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditLimitIdScheme != null ? creditLimitIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitId {" +
				"value=" + this.value + ", " +
				"creditLimitIdScheme=" + this.creditLimitIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LimitId  ***********************/
	class LimitIdBuilderImpl implements LimitId.LimitIdBuilder {
	
		protected String value;
		protected String creditLimitIdScheme;
	
		public LimitIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditLimitIdScheme")
		public String getCreditLimitIdScheme() {
			return creditLimitIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LimitId.LimitIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("creditLimitIdScheme")
		public LimitId.LimitIdBuilder setCreditLimitIdScheme(String creditLimitIdScheme) {
			this.creditLimitIdScheme = creditLimitIdScheme==null?null:creditLimitIdScheme;
			return this;
		}
		
		@Override
		public LimitId build() {
			return new LimitId.LimitIdImpl(this);
		}
		
		@Override
		public LimitId.LimitIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitId.LimitIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditLimitIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitId.LimitIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LimitId.LimitIdBuilder o = (LimitId.LimitIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditLimitIdScheme(), o.getCreditLimitIdScheme(), this::setCreditLimitIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditLimitIdScheme, _that.getCreditLimitIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditLimitIdScheme != null ? creditLimitIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitIdBuilder {" +
				"value=" + this.value + ", " +
				"creditLimitIdScheme=" + this.creditLimitIdScheme +
			'}';
		}
	}
}
