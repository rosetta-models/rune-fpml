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
import fpml.confirmation.IdentifiedPayerReceiver;
import fpml.confirmation.IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder;
import fpml.confirmation.IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilderImpl;
import fpml.confirmation.IdentifiedPayerReceiver.IdentifiedPayerReceiverImpl;
import fpml.confirmation.PayerReceiverEnum;
import fpml.confirmation.meta.IdentifiedPayerReceiverMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type extending the PayerReceiverEnum type wih an id attribute.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="IdentifiedPayerReceiver", builder=IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface IdentifiedPayerReceiver extends RosettaModelObject {

	IdentifiedPayerReceiverMeta metaData = new IdentifiedPayerReceiverMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverEnum getValue();
	String getId();

	/*********************** Build Methods  ***********************/
	IdentifiedPayerReceiver build();
	
	IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder toBuilder();
	
	static IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder() {
		return new IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedPayerReceiver> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IdentifiedPayerReceiver> getType() {
		return IdentifiedPayerReceiver.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), PayerReceiverEnum.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedPayerReceiverBuilder extends IdentifiedPayerReceiver, RosettaModelObjectBuilder {
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setValue(PayerReceiverEnum value);
		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), PayerReceiverEnum.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedPayerReceiver  ***********************/
	class IdentifiedPayerReceiverImpl implements IdentifiedPayerReceiver {
		private final PayerReceiverEnum value;
		private final String id;
		
		protected IdentifiedPayerReceiverImpl(IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		public PayerReceiverEnum getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public IdentifiedPayerReceiver build() {
			return this;
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder toBuilder() {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedPayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedPayerReceiver {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of IdentifiedPayerReceiver  ***********************/
	class IdentifiedPayerReceiverBuilderImpl implements IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder {
	
		protected PayerReceiverEnum value;
		protected String id;
	
		public IdentifiedPayerReceiverBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public PayerReceiverEnum getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("value")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setValue(PayerReceiverEnum value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public IdentifiedPayerReceiver build() {
			return new IdentifiedPayerReceiver.IdentifiedPayerReceiverImpl(this);
		}
		
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder o = (IdentifiedPayerReceiver.IdentifiedPayerReceiverBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IdentifiedPayerReceiver _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IdentifiedPayerReceiverBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
