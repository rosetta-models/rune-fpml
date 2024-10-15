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
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.CreditSeniority.CreditSeniorityBuilder;
import fpml.confirmation.CreditSeniority.CreditSeniorityBuilderImpl;
import fpml.confirmation.CreditSeniority.CreditSeniorityImpl;
import fpml.confirmation.meta.CreditSeniorityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditSeniority", builder=CreditSeniority.CreditSeniorityBuilderImpl.class, version="${project.version}")
public interface CreditSeniority extends RosettaModelObject {

	CreditSeniorityMeta metaData = new CreditSeniorityMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * creditSeniorityTradingScheme overrides creditSeniorityScheme when the underlyer defines the reference obligation used in a single name credit default swap trade.
	 */
	String getCreditSeniorityScheme();

	/*********************** Build Methods  ***********************/
	CreditSeniority build();
	
	CreditSeniority.CreditSeniorityBuilder toBuilder();
	
	static CreditSeniority.CreditSeniorityBuilder builder() {
		return new CreditSeniority.CreditSeniorityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSeniority> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditSeniority> getType() {
		return CreditSeniority.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditSeniorityScheme"), String.class, getCreditSeniorityScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSeniorityBuilder extends CreditSeniority, RosettaModelObjectBuilder {
		CreditSeniority.CreditSeniorityBuilder setValue(String value);
		CreditSeniority.CreditSeniorityBuilder setCreditSeniorityScheme(String creditSeniorityScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditSeniorityScheme"), String.class, getCreditSeniorityScheme(), this);
		}
		

		CreditSeniority.CreditSeniorityBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSeniority  ***********************/
	class CreditSeniorityImpl implements CreditSeniority {
		private final String value;
		private final String creditSeniorityScheme;
		
		protected CreditSeniorityImpl(CreditSeniority.CreditSeniorityBuilder builder) {
			this.value = builder.getValue();
			this.creditSeniorityScheme = builder.getCreditSeniorityScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSeniorityScheme")
		public String getCreditSeniorityScheme() {
			return creditSeniorityScheme;
		}
		
		@Override
		public CreditSeniority build() {
			return this;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder toBuilder() {
			CreditSeniority.CreditSeniorityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSeniority.CreditSeniorityBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditSeniorityScheme()).ifPresent(builder::setCreditSeniorityScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSeniority _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSeniorityScheme, _that.getCreditSeniorityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSeniorityScheme != null ? creditSeniorityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSeniority {" +
				"value=" + this.value + ", " +
				"creditSeniorityScheme=" + this.creditSeniorityScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSeniority  ***********************/
	class CreditSeniorityBuilderImpl implements CreditSeniority.CreditSeniorityBuilder {
	
		protected String value;
		protected String creditSeniorityScheme;
	
		public CreditSeniorityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditSeniorityScheme")
		public String getCreditSeniorityScheme() {
			return creditSeniorityScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CreditSeniority.CreditSeniorityBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("creditSeniorityScheme")
		public CreditSeniority.CreditSeniorityBuilder setCreditSeniorityScheme(String creditSeniorityScheme) {
			this.creditSeniorityScheme = creditSeniorityScheme==null?null:creditSeniorityScheme;
			return this;
		}
		
		@Override
		public CreditSeniority build() {
			return new CreditSeniority.CreditSeniorityImpl(this);
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSeniority.CreditSeniorityBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditSeniorityScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSeniority.CreditSeniorityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSeniority.CreditSeniorityBuilder o = (CreditSeniority.CreditSeniorityBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditSeniorityScheme(), o.getCreditSeniorityScheme(), this::setCreditSeniorityScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSeniority _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditSeniorityScheme, _that.getCreditSeniorityScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditSeniorityScheme != null ? creditSeniorityScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSeniorityBuilder {" +
				"value=" + this.value + ", " +
				"creditSeniorityScheme=" + this.creditSeniorityScheme +
			'}';
		}
	}
}
