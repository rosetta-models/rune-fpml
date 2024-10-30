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
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.LoanTradeReference.LoanTradeReferenceBuilder;
import fpml.confirmation.LoanTradeReference.LoanTradeReferenceBuilderImpl;
import fpml.confirmation.LoanTradeReference.LoanTradeReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.LoanTradeReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to a loan trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanTradeReference", builder=LoanTradeReference.LoanTradeReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanTradeReference extends Reference {

	LoanTradeReferenceMeta metaData = new LoanTradeReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	LoanTradeReference build();
	
	LoanTradeReference.LoanTradeReferenceBuilder toBuilder();
	
	static LoanTradeReference.LoanTradeReferenceBuilder builder() {
		return new LoanTradeReference.LoanTradeReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeReference> getType() {
		return LoanTradeReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeReferenceBuilder extends LoanTradeReference, Reference.ReferenceBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		LoanTradeReference.LoanTradeReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeReference  ***********************/
	class LoanTradeReferenceImpl extends Reference.ReferenceImpl implements LoanTradeReference {
		private final String href;
		
		protected LoanTradeReferenceImpl(LoanTradeReference.LoanTradeReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public LoanTradeReference build() {
			return this;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder toBuilder() {
			LoanTradeReference.LoanTradeReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeReference.LoanTradeReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeReference _that = getType().cast(o);
		
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
			return "LoanTradeReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeReference  ***********************/
	class LoanTradeReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements LoanTradeReference.LoanTradeReferenceBuilder {
	
		protected String href;
	
		public LoanTradeReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public LoanTradeReference.LoanTradeReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public LoanTradeReference build() {
			return new LoanTradeReference.LoanTradeReferenceImpl(this);
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder prune() {
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
		public LoanTradeReference.LoanTradeReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeReference.LoanTradeReferenceBuilder o = (LoanTradeReference.LoanTradeReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeReference _that = getType().cast(o);
		
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
			return "LoanTradeReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
