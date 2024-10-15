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
import fpml.confirmation.PaymentBase;
import fpml.confirmation.PaymentBase.PaymentBaseBuilder;
import fpml.confirmation.PaymentBase.PaymentBaseBuilderImpl;
import fpml.confirmation.PaymentBase.PaymentBaseImpl;
import fpml.confirmation.meta.PaymentBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for payment types.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentBase", builder=PaymentBase.PaymentBaseBuilderImpl.class, version="${project.version}")
public interface PaymentBase extends RosettaModelObject {

	PaymentBaseMeta metaData = new PaymentBaseMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	PaymentBase build();
	
	PaymentBase.PaymentBaseBuilder toBuilder();
	
	static PaymentBase.PaymentBaseBuilder builder() {
		return new PaymentBase.PaymentBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentBase> getType() {
		return PaymentBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentBaseBuilder extends PaymentBase, RosettaModelObjectBuilder {
		PaymentBase.PaymentBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PaymentBase.PaymentBaseBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentBase  ***********************/
	class PaymentBaseImpl implements PaymentBase {
		private final String id;
		
		protected PaymentBaseImpl(PaymentBase.PaymentBaseBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PaymentBase build() {
			return this;
		}
		
		@Override
		public PaymentBase.PaymentBaseBuilder toBuilder() {
			PaymentBase.PaymentBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentBase.PaymentBaseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentBase {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentBase  ***********************/
	class PaymentBaseBuilderImpl implements PaymentBase.PaymentBaseBuilder {
	
		protected String id;
	
		public PaymentBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public PaymentBase.PaymentBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PaymentBase build() {
			return new PaymentBase.PaymentBaseImpl(this);
		}
		
		@Override
		public PaymentBase.PaymentBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentBase.PaymentBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentBase.PaymentBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentBase.PaymentBaseBuilder o = (PaymentBase.PaymentBaseBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentBaseBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
