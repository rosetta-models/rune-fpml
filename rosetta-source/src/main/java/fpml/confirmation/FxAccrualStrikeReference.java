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
import fpml.confirmation.FxAccrualStrikeReference;
import fpml.confirmation.FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder;
import fpml.confirmation.FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilderImpl;
import fpml.confirmation.FxAccrualStrikeReference.FxAccrualStrikeReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.FxAccrualStrikeReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a strike structure in FxAccrualForward or FxAccrualOption products.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualStrikeReference", builder=FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualStrikeReference extends Reference {

	FxAccrualStrikeReferenceMeta metaData = new FxAccrualStrikeReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	FxAccrualStrikeReference build();
	
	FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder toBuilder();
	
	static FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder builder() {
		return new FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualStrikeReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualStrikeReference> getType() {
		return FxAccrualStrikeReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualStrikeReferenceBuilder extends FxAccrualStrikeReference, Reference.ReferenceBuilder {
		FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualStrikeReference  ***********************/
	class FxAccrualStrikeReferenceImpl extends Reference.ReferenceImpl implements FxAccrualStrikeReference {
		private final String href;
		
		protected FxAccrualStrikeReferenceImpl(FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public FxAccrualStrikeReference build() {
			return this;
		}
		
		@Override
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder toBuilder() {
			FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualStrikeReference _that = getType().cast(o);
		
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
			return "FxAccrualStrikeReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualStrikeReference  ***********************/
	class FxAccrualStrikeReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder {
	
		protected String href;
	
		public FxAccrualStrikeReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public FxAccrualStrikeReference build() {
			return new FxAccrualStrikeReference.FxAccrualStrikeReferenceImpl(this);
		}
		
		@Override
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder prune() {
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
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder o = (FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualStrikeReference _that = getType().cast(o);
		
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
			return "FxAccrualStrikeReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
