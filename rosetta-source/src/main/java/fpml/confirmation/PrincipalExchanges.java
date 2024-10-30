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
import fpml.confirmation.PrincipalExchanges;
import fpml.confirmation.PrincipalExchanges.PrincipalExchangesBuilder;
import fpml.confirmation.PrincipalExchanges.PrincipalExchangesBuilderImpl;
import fpml.confirmation.PrincipalExchanges.PrincipalExchangesImpl;
import fpml.confirmation.meta.PrincipalExchangesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining which principal exchanges occur for the stream.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PrincipalExchanges", builder=PrincipalExchanges.PrincipalExchangesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PrincipalExchanges extends RosettaModelObject {

	PrincipalExchangesMeta metaData = new PrincipalExchangesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
	 */
	Boolean getInitialExchange();
	/**
	 * A true/false flag to indicate whether there is a final exchange of principal on the termination date.
	 */
	Boolean getFinalExchange();
	/**
	 * A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
	 */
	Boolean getIntermediateExchange();
	String getId();

	/*********************** Build Methods  ***********************/
	PrincipalExchanges build();
	
	PrincipalExchanges.PrincipalExchangesBuilder toBuilder();
	
	static PrincipalExchanges.PrincipalExchangesBuilder builder() {
		return new PrincipalExchanges.PrincipalExchangesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchanges> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrincipalExchanges> getType() {
		return PrincipalExchanges.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialExchange"), Boolean.class, getInitialExchange(), this);
		processor.processBasic(path.newSubPath("finalExchange"), Boolean.class, getFinalExchange(), this);
		processor.processBasic(path.newSubPath("intermediateExchange"), Boolean.class, getIntermediateExchange(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangesBuilder extends PrincipalExchanges, RosettaModelObjectBuilder {
		PrincipalExchanges.PrincipalExchangesBuilder setInitialExchange(Boolean initialExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setFinalExchange(Boolean finalExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setIntermediateExchange(Boolean intermediateExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialExchange"), Boolean.class, getInitialExchange(), this);
			processor.processBasic(path.newSubPath("finalExchange"), Boolean.class, getFinalExchange(), this);
			processor.processBasic(path.newSubPath("intermediateExchange"), Boolean.class, getIntermediateExchange(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PrincipalExchanges.PrincipalExchangesBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchanges  ***********************/
	class PrincipalExchangesImpl implements PrincipalExchanges {
		private final Boolean initialExchange;
		private final Boolean finalExchange;
		private final Boolean intermediateExchange;
		private final String id;
		
		protected PrincipalExchangesImpl(PrincipalExchanges.PrincipalExchangesBuilder builder) {
			this.initialExchange = builder.getInitialExchange();
			this.finalExchange = builder.getFinalExchange();
			this.intermediateExchange = builder.getIntermediateExchange();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("initialExchange")
		public Boolean getInitialExchange() {
			return initialExchange;
		}
		
		@Override
		@RosettaAttribute("finalExchange")
		public Boolean getFinalExchange() {
			return finalExchange;
		}
		
		@Override
		@RosettaAttribute("intermediateExchange")
		public Boolean getIntermediateExchange() {
			return intermediateExchange;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PrincipalExchanges build() {
			return this;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder toBuilder() {
			PrincipalExchanges.PrincipalExchangesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchanges.PrincipalExchangesBuilder builder) {
			ofNullable(getInitialExchange()).ifPresent(builder::setInitialExchange);
			ofNullable(getFinalExchange()).ifPresent(builder::setFinalExchange);
			ofNullable(getIntermediateExchange()).ifPresent(builder::setIntermediateExchange);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchanges _that = getType().cast(o);
		
			if (!Objects.equals(initialExchange, _that.getInitialExchange())) return false;
			if (!Objects.equals(finalExchange, _that.getFinalExchange())) return false;
			if (!Objects.equals(intermediateExchange, _that.getIntermediateExchange())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialExchange != null ? initialExchange.hashCode() : 0);
			_result = 31 * _result + (finalExchange != null ? finalExchange.hashCode() : 0);
			_result = 31 * _result + (intermediateExchange != null ? intermediateExchange.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchanges {" +
				"initialExchange=" + this.initialExchange + ", " +
				"finalExchange=" + this.finalExchange + ", " +
				"intermediateExchange=" + this.intermediateExchange + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchanges  ***********************/
	class PrincipalExchangesBuilderImpl implements PrincipalExchanges.PrincipalExchangesBuilder {
	
		protected Boolean initialExchange;
		protected Boolean finalExchange;
		protected Boolean intermediateExchange;
		protected String id;
	
		public PrincipalExchangesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialExchange")
		public Boolean getInitialExchange() {
			return initialExchange;
		}
		
		@Override
		@RosettaAttribute("finalExchange")
		public Boolean getFinalExchange() {
			return finalExchange;
		}
		
		@Override
		@RosettaAttribute("intermediateExchange")
		public Boolean getIntermediateExchange() {
			return intermediateExchange;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("initialExchange")
		public PrincipalExchanges.PrincipalExchangesBuilder setInitialExchange(Boolean initialExchange) {
			this.initialExchange = initialExchange==null?null:initialExchange;
			return this;
		}
		@Override
		@RosettaAttribute("finalExchange")
		public PrincipalExchanges.PrincipalExchangesBuilder setFinalExchange(Boolean finalExchange) {
			this.finalExchange = finalExchange==null?null:finalExchange;
			return this;
		}
		@Override
		@RosettaAttribute("intermediateExchange")
		public PrincipalExchanges.PrincipalExchangesBuilder setIntermediateExchange(Boolean intermediateExchange) {
			this.intermediateExchange = intermediateExchange==null?null:intermediateExchange;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PrincipalExchanges.PrincipalExchangesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PrincipalExchanges build() {
			return new PrincipalExchanges.PrincipalExchangesImpl(this);
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialExchange()!=null) return true;
			if (getFinalExchange()!=null) return true;
			if (getIntermediateExchange()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchanges.PrincipalExchangesBuilder o = (PrincipalExchanges.PrincipalExchangesBuilder) other;
			
			
			merger.mergeBasic(getInitialExchange(), o.getInitialExchange(), this::setInitialExchange);
			merger.mergeBasic(getFinalExchange(), o.getFinalExchange(), this::setFinalExchange);
			merger.mergeBasic(getIntermediateExchange(), o.getIntermediateExchange(), this::setIntermediateExchange);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchanges _that = getType().cast(o);
		
			if (!Objects.equals(initialExchange, _that.getInitialExchange())) return false;
			if (!Objects.equals(finalExchange, _that.getFinalExchange())) return false;
			if (!Objects.equals(intermediateExchange, _that.getIntermediateExchange())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialExchange != null ? initialExchange.hashCode() : 0);
			_result = 31 * _result + (finalExchange != null ? finalExchange.hashCode() : 0);
			_result = 31 * _result + (intermediateExchange != null ? intermediateExchange.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangesBuilder {" +
				"initialExchange=" + this.initialExchange + ", " +
				"finalExchange=" + this.finalExchange + ", " +
				"intermediateExchange=" + this.intermediateExchange + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
