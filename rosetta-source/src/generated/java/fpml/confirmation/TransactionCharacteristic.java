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
import fpml.confirmation.TransactionCharacteristic;
import fpml.confirmation.TransactionCharacteristic.TransactionCharacteristicBuilder;
import fpml.confirmation.TransactionCharacteristic.TransactionCharacteristicBuilderImpl;
import fpml.confirmation.TransactionCharacteristic.TransactionCharacteristicImpl;
import fpml.confirmation.meta.TransactionCharacteristicMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A characteristic of a transaction used in declaring an end-user exception.
 * @version ${project.version}
 */
@RosettaDataType(value="TransactionCharacteristic", builder=TransactionCharacteristic.TransactionCharacteristicBuilderImpl.class, version="${project.version}")
public interface TransactionCharacteristic extends RosettaModelObject {

	TransactionCharacteristicMeta metaData = new TransactionCharacteristicMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getTransactionCharacteristicScheme();

	/*********************** Build Methods  ***********************/
	TransactionCharacteristic build();
	
	TransactionCharacteristic.TransactionCharacteristicBuilder toBuilder();
	
	static TransactionCharacteristic.TransactionCharacteristicBuilder builder() {
		return new TransactionCharacteristic.TransactionCharacteristicBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransactionCharacteristic> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransactionCharacteristic> getType() {
		return TransactionCharacteristic.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("transactionCharacteristicScheme"), String.class, getTransactionCharacteristicScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransactionCharacteristicBuilder extends TransactionCharacteristic, RosettaModelObjectBuilder {
		TransactionCharacteristic.TransactionCharacteristicBuilder setValue(String value);
		TransactionCharacteristic.TransactionCharacteristicBuilder setTransactionCharacteristicScheme(String transactionCharacteristicScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("transactionCharacteristicScheme"), String.class, getTransactionCharacteristicScheme(), this);
		}
		

		TransactionCharacteristic.TransactionCharacteristicBuilder prune();
	}

	/*********************** Immutable Implementation of TransactionCharacteristic  ***********************/
	class TransactionCharacteristicImpl implements TransactionCharacteristic {
		private final String value;
		private final String transactionCharacteristicScheme;
		
		protected TransactionCharacteristicImpl(TransactionCharacteristic.TransactionCharacteristicBuilder builder) {
			this.value = builder.getValue();
			this.transactionCharacteristicScheme = builder.getTransactionCharacteristicScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristicScheme")
		public String getTransactionCharacteristicScheme() {
			return transactionCharacteristicScheme;
		}
		
		@Override
		public TransactionCharacteristic build() {
			return this;
		}
		
		@Override
		public TransactionCharacteristic.TransactionCharacteristicBuilder toBuilder() {
			TransactionCharacteristic.TransactionCharacteristicBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransactionCharacteristic.TransactionCharacteristicBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTransactionCharacteristicScheme()).ifPresent(builder::setTransactionCharacteristicScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransactionCharacteristic _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(transactionCharacteristicScheme, _that.getTransactionCharacteristicScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristicScheme != null ? transactionCharacteristicScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionCharacteristic {" +
				"value=" + this.value + ", " +
				"transactionCharacteristicScheme=" + this.transactionCharacteristicScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TransactionCharacteristic  ***********************/
	class TransactionCharacteristicBuilderImpl implements TransactionCharacteristic.TransactionCharacteristicBuilder {
	
		protected String value;
		protected String transactionCharacteristicScheme;
	
		public TransactionCharacteristicBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("transactionCharacteristicScheme")
		public String getTransactionCharacteristicScheme() {
			return transactionCharacteristicScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public TransactionCharacteristic.TransactionCharacteristicBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("transactionCharacteristicScheme")
		public TransactionCharacteristic.TransactionCharacteristicBuilder setTransactionCharacteristicScheme(String transactionCharacteristicScheme) {
			this.transactionCharacteristicScheme = transactionCharacteristicScheme==null?null:transactionCharacteristicScheme;
			return this;
		}
		
		@Override
		public TransactionCharacteristic build() {
			return new TransactionCharacteristic.TransactionCharacteristicImpl(this);
		}
		
		@Override
		public TransactionCharacteristic.TransactionCharacteristicBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionCharacteristic.TransactionCharacteristicBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTransactionCharacteristicScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionCharacteristic.TransactionCharacteristicBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransactionCharacteristic.TransactionCharacteristicBuilder o = (TransactionCharacteristic.TransactionCharacteristicBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTransactionCharacteristicScheme(), o.getTransactionCharacteristicScheme(), this::setTransactionCharacteristicScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransactionCharacteristic _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(transactionCharacteristicScheme, _that.getTransactionCharacteristicScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (transactionCharacteristicScheme != null ? transactionCharacteristicScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionCharacteristicBuilder {" +
				"value=" + this.value + ", " +
				"transactionCharacteristicScheme=" + this.transactionCharacteristicScheme +
			'}';
		}
	}
}
