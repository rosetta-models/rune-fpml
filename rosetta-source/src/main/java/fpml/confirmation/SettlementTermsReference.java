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
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.SettlementTermsReference;
import fpml.confirmation.SettlementTermsReference.SettlementTermsReferenceBuilder;
import fpml.confirmation.SettlementTermsReference.SettlementTermsReferenceBuilderImpl;
import fpml.confirmation.SettlementTermsReference.SettlementTermsReferenceImpl;
import fpml.confirmation.meta.SettlementTermsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a settlement terms derived construct (cashSettlementTerms or physicalSettlementTerms).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SettlementTermsReference", builder=SettlementTermsReference.SettlementTermsReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SettlementTermsReference extends Reference {

	SettlementTermsReferenceMeta metaData = new SettlementTermsReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	SettlementTermsReference build();
	
	SettlementTermsReference.SettlementTermsReferenceBuilder toBuilder();
	
	static SettlementTermsReference.SettlementTermsReferenceBuilder builder() {
		return new SettlementTermsReference.SettlementTermsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementTermsReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementTermsReference> getType() {
		return SettlementTermsReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementTermsReferenceBuilder extends SettlementTermsReference, Reference.ReferenceBuilder {
		SettlementTermsReference.SettlementTermsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		SettlementTermsReference.SettlementTermsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementTermsReference  ***********************/
	class SettlementTermsReferenceImpl extends Reference.ReferenceImpl implements SettlementTermsReference {
		private final String href;
		
		protected SettlementTermsReferenceImpl(SettlementTermsReference.SettlementTermsReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public SettlementTermsReference build() {
			return this;
		}
		
		@Override
		public SettlementTermsReference.SettlementTermsReferenceBuilder toBuilder() {
			SettlementTermsReference.SettlementTermsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementTermsReference.SettlementTermsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementTermsReference _that = getType().cast(o);
		
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
			return "SettlementTermsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SettlementTermsReference  ***********************/
	class SettlementTermsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements SettlementTermsReference.SettlementTermsReferenceBuilder {
	
		protected String href;
	
		public SettlementTermsReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public SettlementTermsReference.SettlementTermsReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public SettlementTermsReference build() {
			return new SettlementTermsReference.SettlementTermsReferenceImpl(this);
		}
		
		@Override
		public SettlementTermsReference.SettlementTermsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTermsReference.SettlementTermsReferenceBuilder prune() {
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
		public SettlementTermsReference.SettlementTermsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SettlementTermsReference.SettlementTermsReferenceBuilder o = (SettlementTermsReference.SettlementTermsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementTermsReference _that = getType().cast(o);
		
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
			return "SettlementTermsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
