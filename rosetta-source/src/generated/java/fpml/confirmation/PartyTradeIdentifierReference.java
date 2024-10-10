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
import fpml.confirmation.PartyTradeIdentifierReference;
import fpml.confirmation.PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder;
import fpml.confirmation.PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilderImpl;
import fpml.confirmation.PartyTradeIdentifierReference.PartyTradeIdentifierReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.PartyTradeIdentifierReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to a partyTradeIdentifier object.
 * @version ${project.version}
 */
@RosettaDataType(value="PartyTradeIdentifierReference", builder=PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilderImpl.class, version="${project.version}")
public interface PartyTradeIdentifierReference extends Reference {

	PartyTradeIdentifierReferenceMeta metaData = new PartyTradeIdentifierReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	PartyTradeIdentifierReference build();
	
	PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder toBuilder();
	
	static PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder builder() {
		return new PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeIdentifierReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyTradeIdentifierReference> getType() {
		return PartyTradeIdentifierReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeIdentifierReferenceBuilder extends PartyTradeIdentifierReference, Reference.ReferenceBuilder {
		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeIdentifierReference  ***********************/
	class PartyTradeIdentifierReferenceImpl extends Reference.ReferenceImpl implements PartyTradeIdentifierReference {
		private final String href;
		
		protected PartyTradeIdentifierReferenceImpl(PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public PartyTradeIdentifierReference build() {
			return this;
		}
		
		@Override
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder toBuilder() {
			PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyTradeIdentifierReference _that = getType().cast(o);
		
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
			return "PartyTradeIdentifierReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PartyTradeIdentifierReference  ***********************/
	class PartyTradeIdentifierReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder {
	
		protected String href;
	
		public PartyTradeIdentifierReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public PartyTradeIdentifierReference build() {
			return new PartyTradeIdentifierReference.PartyTradeIdentifierReferenceImpl(this);
		}
		
		@Override
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder prune() {
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
		public PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder o = (PartyTradeIdentifierReference.PartyTradeIdentifierReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PartyTradeIdentifierReference _that = getType().cast(o);
		
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
			return "PartyTradeIdentifierReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
