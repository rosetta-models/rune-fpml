package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.FxDisruptionEvent;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilder;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventBuilderImpl;
import fpml.confirmation.FxDisruptionEvent.FxDisruptionEventImpl;
import fpml.confirmation.PriceSourceDisruption;
import fpml.confirmation.PriceSourceDisruption.PriceSourceDisruptionBuilder;
import fpml.confirmation.PriceSourceDisruption.PriceSourceDisruptionBuilderImpl;
import fpml.confirmation.PriceSourceDisruption.PriceSourceDisruptionImpl;
import fpml.confirmation.meta.PriceSourceDisruptionMeta;


/**
 * If present indicates that the event is considered to have occurred if it is impossible to obtain information about the Spot Rate for a Valuation Date from the price source specified in the Settlement Rate Option that hass been agreed by the parties.
 * @version ${project.version}
 */
@RosettaDataType(value="PriceSourceDisruption", builder=PriceSourceDisruption.PriceSourceDisruptionBuilderImpl.class, version="${project.version}")
public interface PriceSourceDisruption extends FxDisruptionEvent {

	PriceSourceDisruptionMeta metaData = new PriceSourceDisruptionMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PriceSourceDisruption build();
	
	PriceSourceDisruption.PriceSourceDisruptionBuilder toBuilder();
	
	static PriceSourceDisruption.PriceSourceDisruptionBuilder builder() {
		return new PriceSourceDisruption.PriceSourceDisruptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceSourceDisruption> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PriceSourceDisruption> getType() {
		return PriceSourceDisruption.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceSourceDisruptionBuilder extends PriceSourceDisruption, FxDisruptionEvent.FxDisruptionEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		PriceSourceDisruption.PriceSourceDisruptionBuilder prune();
	}

	/*********************** Immutable Implementation of PriceSourceDisruption  ***********************/
	class PriceSourceDisruptionImpl extends FxDisruptionEvent.FxDisruptionEventImpl implements PriceSourceDisruption {
		
		protected PriceSourceDisruptionImpl(PriceSourceDisruption.PriceSourceDisruptionBuilder builder) {
			super(builder);
		}
		
		@Override
		public PriceSourceDisruption build() {
			return this;
		}
		
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder toBuilder() {
			PriceSourceDisruption.PriceSourceDisruptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceSourceDisruption.PriceSourceDisruptionBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "PriceSourceDisruption {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PriceSourceDisruption  ***********************/
	class PriceSourceDisruptionBuilderImpl extends FxDisruptionEvent.FxDisruptionEventBuilderImpl  implements PriceSourceDisruption.PriceSourceDisruptionBuilder {
	
	
		public PriceSourceDisruptionBuilderImpl() {
		}
	
		
		@Override
		public PriceSourceDisruption build() {
			return new PriceSourceDisruption.PriceSourceDisruptionImpl(this);
		}
		
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceSourceDisruption.PriceSourceDisruptionBuilder prune() {
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
		public PriceSourceDisruption.PriceSourceDisruptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			PriceSourceDisruption.PriceSourceDisruptionBuilder o = (PriceSourceDisruption.PriceSourceDisruptionBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "PriceSourceDisruptionBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
