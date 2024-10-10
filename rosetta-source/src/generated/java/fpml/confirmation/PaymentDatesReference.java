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
import fpml.confirmation.PaymentDatesReference;
import fpml.confirmation.PaymentDatesReference.PaymentDatesReferenceBuilder;
import fpml.confirmation.PaymentDatesReference.PaymentDatesReferenceBuilderImpl;
import fpml.confirmation.PaymentDatesReference.PaymentDatesReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.PaymentDatesReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a payment dates structure.
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentDatesReference", builder=PaymentDatesReference.PaymentDatesReferenceBuilderImpl.class, version="${project.version}")
public interface PaymentDatesReference extends Reference {

	PaymentDatesReferenceMeta metaData = new PaymentDatesReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	PaymentDatesReference build();
	
	PaymentDatesReference.PaymentDatesReferenceBuilder toBuilder();
	
	static PaymentDatesReference.PaymentDatesReferenceBuilder builder() {
		return new PaymentDatesReference.PaymentDatesReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentDatesReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PaymentDatesReference> getType() {
		return PaymentDatesReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentDatesReferenceBuilder extends PaymentDatesReference, Reference.ReferenceBuilder {
		PaymentDatesReference.PaymentDatesReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PaymentDatesReference.PaymentDatesReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PaymentDatesReference  ***********************/
	class PaymentDatesReferenceImpl extends Reference.ReferenceImpl implements PaymentDatesReference {
		private final String href;
		
		protected PaymentDatesReferenceImpl(PaymentDatesReference.PaymentDatesReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PaymentDatesReference build() {
			return this;
		}
		
		@Override
		public PaymentDatesReference.PaymentDatesReferenceBuilder toBuilder() {
			PaymentDatesReference.PaymentDatesReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentDatesReference.PaymentDatesReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentDatesReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDatesReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PaymentDatesReference  ***********************/
	class PaymentDatesReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements PaymentDatesReference.PaymentDatesReferenceBuilder {
	
		protected String href;
	
		public PaymentDatesReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public PaymentDatesReference.PaymentDatesReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PaymentDatesReference build() {
			return new PaymentDatesReference.PaymentDatesReferenceImpl(this);
		}
		
		@Override
		public PaymentDatesReference.PaymentDatesReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDatesReference.PaymentDatesReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentDatesReference.PaymentDatesReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PaymentDatesReference.PaymentDatesReferenceBuilder o = (PaymentDatesReference.PaymentDatesReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PaymentDatesReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentDatesReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
