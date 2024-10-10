package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.ExchangeRestrictions;
import fpml.confirmation.ExchangeRestrictions.ExchangeRestrictionsBuilder;
import fpml.confirmation.ExchangeRestrictions.ExchangeRestrictionsBuilderImpl;
import fpml.confirmation.ExchangeRestrictions.ExchangeRestrictionsImpl;
import fpml.confirmation.FxDisruptionEvent;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilder;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilderImpl;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventImpl;
import fpml.confirmation.meta.ExchangeRestrictionsMeta;


/**
 * If present indicates that the event is considered to have occured if the settlement in either currency is prohibited or materially restricted.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeRestrictions", builder=ExchangeRestrictions.ExchangeRestrictionsBuilderImpl.class, version="${project.version}")
public interface ExchangeRestrictions extends FxDisruptionEvent {

	ExchangeRestrictionsMeta metaData = new ExchangeRestrictionsMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	ExchangeRestrictions build();
	
	ExchangeRestrictions.ExchangeRestrictionsBuilder toBuilder();
	
	static ExchangeRestrictions.ExchangeRestrictionsBuilder builder() {
		return new ExchangeRestrictions.ExchangeRestrictionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeRestrictions> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeRestrictions> getType() {
		return ExchangeRestrictions.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeRestrictionsBuilder extends ExchangeRestrictions, FxDisruptionEvent.FxDisruptionEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		ExchangeRestrictions.ExchangeRestrictionsBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeRestrictions  ***********************/
	class ExchangeRestrictionsImpl extends FxDisruptionEvent.FxDisruptionEventImpl implements ExchangeRestrictions {
		
		protected ExchangeRestrictionsImpl(ExchangeRestrictions.ExchangeRestrictionsBuilder builder) {
			super(builder);
		}
		
		@Override
		public ExchangeRestrictions build() {
			return this;
		}
		
		@Override
		public ExchangeRestrictions.ExchangeRestrictionsBuilder toBuilder() {
			ExchangeRestrictions.ExchangeRestrictionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeRestrictions.ExchangeRestrictionsBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRestrictions {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeRestrictions  ***********************/
	class ExchangeRestrictionsBuilderImpl extends FxDisruptionEvent.FxDisruptionEventBuilderImpl  implements ExchangeRestrictions.ExchangeRestrictionsBuilder {
	
	
		public ExchangeRestrictionsBuilderImpl() {
		}
	
		
		@Override
		public ExchangeRestrictions build() {
			return new ExchangeRestrictions.ExchangeRestrictionsImpl(this);
		}
		
		@Override
		public ExchangeRestrictions.ExchangeRestrictionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRestrictions.ExchangeRestrictionsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeRestrictions.ExchangeRestrictionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExchangeRestrictions.ExchangeRestrictionsBuilder o = (ExchangeRestrictions.ExchangeRestrictionsBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeRestrictionsBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
