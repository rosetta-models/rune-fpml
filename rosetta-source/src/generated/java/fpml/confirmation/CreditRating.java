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
import fpml.confirmation.CreditRating;
import fpml.confirmation.CreditRating.CreditRatingBuilder;
import fpml.confirmation.CreditRating.CreditRatingBuilderImpl;
import fpml.confirmation.CreditRating.CreditRatingImpl;
import fpml.confirmation.meta.CreditRatingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A party&#39;s credit rating.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditRating", builder=CreditRating.CreditRatingBuilderImpl.class, version="${project.version}")
public interface CreditRating extends RosettaModelObject {

	CreditRatingMeta metaData = new CreditRatingMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getCreditRatingScheme();

	/*********************** Build Methods  ***********************/
	CreditRating build();
	
	CreditRating.CreditRatingBuilder toBuilder();
	
	static CreditRating.CreditRatingBuilder builder() {
		return new CreditRating.CreditRatingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditRating> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditRating> getType() {
		return CreditRating.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("creditRatingScheme"), String.class, getCreditRatingScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditRatingBuilder extends CreditRating, RosettaModelObjectBuilder {
		CreditRating.CreditRatingBuilder setValue(String value);
		CreditRating.CreditRatingBuilder setCreditRatingScheme(String creditRatingScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("creditRatingScheme"), String.class, getCreditRatingScheme(), this);
		}
		

		CreditRating.CreditRatingBuilder prune();
	}

	/*********************** Immutable Implementation of CreditRating  ***********************/
	class CreditRatingImpl implements CreditRating {
		private final String value;
		private final String creditRatingScheme;
		
		protected CreditRatingImpl(CreditRating.CreditRatingBuilder builder) {
			this.value = builder.getValue();
			this.creditRatingScheme = builder.getCreditRatingScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditRatingScheme")
		public String getCreditRatingScheme() {
			return creditRatingScheme;
		}
		
		@Override
		public CreditRating build() {
			return this;
		}
		
		@Override
		public CreditRating.CreditRatingBuilder toBuilder() {
			CreditRating.CreditRatingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditRating.CreditRatingBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCreditRatingScheme()).ifPresent(builder::setCreditRatingScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditRating _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditRatingScheme, _that.getCreditRatingScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditRatingScheme != null ? creditRatingScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditRating {" +
				"value=" + this.value + ", " +
				"creditRatingScheme=" + this.creditRatingScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditRating  ***********************/
	class CreditRatingBuilderImpl implements CreditRating.CreditRatingBuilder {
	
		protected String value;
		protected String creditRatingScheme;
	
		public CreditRatingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("creditRatingScheme")
		public String getCreditRatingScheme() {
			return creditRatingScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public CreditRating.CreditRatingBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("creditRatingScheme")
		public CreditRating.CreditRatingBuilder setCreditRatingScheme(String creditRatingScheme) {
			this.creditRatingScheme = creditRatingScheme==null?null:creditRatingScheme;
			return this;
		}
		
		@Override
		public CreditRating build() {
			return new CreditRating.CreditRatingImpl(this);
		}
		
		@Override
		public CreditRating.CreditRatingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditRating.CreditRatingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCreditRatingScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditRating.CreditRatingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditRating.CreditRatingBuilder o = (CreditRating.CreditRatingBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCreditRatingScheme(), o.getCreditRatingScheme(), this::setCreditRatingScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditRating _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(creditRatingScheme, _that.getCreditRatingScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (creditRatingScheme != null ? creditRatingScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditRatingBuilder {" +
				"value=" + this.value + ", " +
				"creditRatingScheme=" + this.creditRatingScheme +
			'}';
		}
	}
}
