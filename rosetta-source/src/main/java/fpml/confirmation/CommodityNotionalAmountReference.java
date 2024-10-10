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
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder;
import fpml.confirmation.CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilderImpl;
import fpml.confirmation.CommodityNotionalAmountReference.CommodityNotionalAmountReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.CommodityNotionalAmountReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to the return swap notional amount.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityNotionalAmountReference", builder=CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilderImpl.class, version="${project.version}")
public interface CommodityNotionalAmountReference extends Reference {

	CommodityNotionalAmountReferenceMeta metaData = new CommodityNotionalAmountReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	CommodityNotionalAmountReference build();
	
	CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder toBuilder();
	
	static CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder builder() {
		return new CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityNotionalAmountReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityNotionalAmountReference> getType() {
		return CommodityNotionalAmountReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityNotionalAmountReferenceBuilder extends CommodityNotionalAmountReference, Reference.ReferenceBuilder {
		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityNotionalAmountReference  ***********************/
	class CommodityNotionalAmountReferenceImpl extends Reference.ReferenceImpl implements CommodityNotionalAmountReference {
		private final String href;
		
		protected CommodityNotionalAmountReferenceImpl(CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CommodityNotionalAmountReference build() {
			return this;
		}
		
		@Override
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder toBuilder() {
			CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityNotionalAmountReference _that = getType().cast(o);
		
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
			return "CommodityNotionalAmountReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityNotionalAmountReference  ***********************/
	class CommodityNotionalAmountReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder {
	
		protected String href;
	
		public CommodityNotionalAmountReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public CommodityNotionalAmountReference build() {
			return new CommodityNotionalAmountReference.CommodityNotionalAmountReferenceImpl(this);
		}
		
		@Override
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder prune() {
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
		public CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder o = (CommodityNotionalAmountReference.CommodityNotionalAmountReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityNotionalAmountReference _that = getType().cast(o);
		
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
			return "CommodityNotionalAmountReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
