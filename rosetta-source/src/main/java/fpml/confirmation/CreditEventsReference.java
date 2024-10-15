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
import fpml.confirmation.CreditEventsReference;
import fpml.confirmation.CreditEventsReference.CreditEventsReferenceBuilder;
import fpml.confirmation.CreditEventsReference.CreditEventsReferenceBuilderImpl;
import fpml.confirmation.CreditEventsReference.CreditEventsReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.CreditEventsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to credit events.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEventsReference", builder=CreditEventsReference.CreditEventsReferenceBuilderImpl.class, version="${project.version}")
public interface CreditEventsReference extends Reference {

	CreditEventsReferenceMeta metaData = new CreditEventsReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	CreditEventsReference build();
	
	CreditEventsReference.CreditEventsReferenceBuilder toBuilder();
	
	static CreditEventsReference.CreditEventsReferenceBuilder builder() {
		return new CreditEventsReference.CreditEventsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventsReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventsReference> getType() {
		return CreditEventsReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventsReferenceBuilder extends CreditEventsReference, Reference.ReferenceBuilder {
		CreditEventsReference.CreditEventsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CreditEventsReference.CreditEventsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventsReference  ***********************/
	class CreditEventsReferenceImpl extends Reference.ReferenceImpl implements CreditEventsReference {
		private final String href;
		
		protected CreditEventsReferenceImpl(CreditEventsReference.CreditEventsReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CreditEventsReference build() {
			return this;
		}
		
		@Override
		public CreditEventsReference.CreditEventsReferenceBuilder toBuilder() {
			CreditEventsReference.CreditEventsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventsReference.CreditEventsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventsReference _that = getType().cast(o);
		
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
			return "CreditEventsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventsReference  ***********************/
	class CreditEventsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements CreditEventsReference.CreditEventsReferenceBuilder {
	
		protected String href;
	
		public CreditEventsReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public CreditEventsReference.CreditEventsReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public CreditEventsReference build() {
			return new CreditEventsReference.CreditEventsReferenceImpl(this);
		}
		
		@Override
		public CreditEventsReference.CreditEventsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventsReference.CreditEventsReferenceBuilder prune() {
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
		public CreditEventsReference.CreditEventsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditEventsReference.CreditEventsReferenceBuilder o = (CreditEventsReference.CreditEventsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventsReference _that = getType().cast(o);
		
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
			return "CreditEventsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
