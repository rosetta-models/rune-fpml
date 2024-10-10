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
import fpml.confirmation.LenderClassification;
import fpml.confirmation.LenderClassification.LenderClassificationBuilder;
import fpml.confirmation.LenderClassification.LenderClassificationBuilderImpl;
import fpml.confirmation.LenderClassification.LenderClassificationImpl;
import fpml.confirmation.meta.LenderClassificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A list of lender clasifications. These are used to derive other rules associated with specific lender types.
 * @version ${project.version}
 */
@RosettaDataType(value="LenderClassification", builder=LenderClassification.LenderClassificationBuilderImpl.class, version="${project.version}")
public interface LenderClassification extends RosettaModelObject {

	LenderClassificationMeta metaData = new LenderClassificationMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getLenderClassificationScheme();

	/*********************** Build Methods  ***********************/
	LenderClassification build();
	
	LenderClassification.LenderClassificationBuilder toBuilder();
	
	static LenderClassification.LenderClassificationBuilder builder() {
		return new LenderClassification.LenderClassificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LenderClassification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LenderClassification> getType() {
		return LenderClassification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lenderClassificationScheme"), String.class, getLenderClassificationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LenderClassificationBuilder extends LenderClassification, RosettaModelObjectBuilder {
		LenderClassification.LenderClassificationBuilder setValue(String value);
		LenderClassification.LenderClassificationBuilder setLenderClassificationScheme(String lenderClassificationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lenderClassificationScheme"), String.class, getLenderClassificationScheme(), this);
		}
		

		LenderClassification.LenderClassificationBuilder prune();
	}

	/*********************** Immutable Implementation of LenderClassification  ***********************/
	class LenderClassificationImpl implements LenderClassification {
		private final String value;
		private final String lenderClassificationScheme;
		
		protected LenderClassificationImpl(LenderClassification.LenderClassificationBuilder builder) {
			this.value = builder.getValue();
			this.lenderClassificationScheme = builder.getLenderClassificationScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lenderClassificationScheme")
		public String getLenderClassificationScheme() {
			return lenderClassificationScheme;
		}
		
		@Override
		public LenderClassification build() {
			return this;
		}
		
		@Override
		public LenderClassification.LenderClassificationBuilder toBuilder() {
			LenderClassification.LenderClassificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LenderClassification.LenderClassificationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLenderClassificationScheme()).ifPresent(builder::setLenderClassificationScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LenderClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lenderClassificationScheme, _that.getLenderClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lenderClassificationScheme != null ? lenderClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LenderClassification {" +
				"value=" + this.value + ", " +
				"lenderClassificationScheme=" + this.lenderClassificationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LenderClassification  ***********************/
	class LenderClassificationBuilderImpl implements LenderClassification.LenderClassificationBuilder {
	
		protected String value;
		protected String lenderClassificationScheme;
	
		public LenderClassificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lenderClassificationScheme")
		public String getLenderClassificationScheme() {
			return lenderClassificationScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public LenderClassification.LenderClassificationBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("lenderClassificationScheme")
		public LenderClassification.LenderClassificationBuilder setLenderClassificationScheme(String lenderClassificationScheme) {
			this.lenderClassificationScheme = lenderClassificationScheme==null?null:lenderClassificationScheme;
			return this;
		}
		
		@Override
		public LenderClassification build() {
			return new LenderClassification.LenderClassificationImpl(this);
		}
		
		@Override
		public LenderClassification.LenderClassificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LenderClassification.LenderClassificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLenderClassificationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LenderClassification.LenderClassificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LenderClassification.LenderClassificationBuilder o = (LenderClassification.LenderClassificationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLenderClassificationScheme(), o.getLenderClassificationScheme(), this::setLenderClassificationScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LenderClassification _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lenderClassificationScheme, _that.getLenderClassificationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lenderClassificationScheme != null ? lenderClassificationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LenderClassificationBuilder {" +
				"value=" + this.value + ", " +
				"lenderClassificationScheme=" + this.lenderClassificationScheme +
			'}';
		}
	}
}
