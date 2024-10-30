package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEvent.CreditEventBuilder;
import fpml.confirmation.CreditEvent.CreditEventBuilderImpl;
import fpml.confirmation.CreditEvent.CreditEventImpl;
import fpml.confirmation.RepudiationMoratoriumEvent;
import fpml.confirmation.RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder;
import fpml.confirmation.RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilderImpl;
import fpml.confirmation.RepudiationMoratoriumEvent.RepudiationMoratoriumEventImpl;
import fpml.confirmation.meta.RepudiationMoratoriumEventMeta;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RepudiationMoratoriumEvent", builder=RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RepudiationMoratoriumEvent extends CreditEvent {

	RepudiationMoratoriumEventMeta metaData = new RepudiationMoratoriumEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RepudiationMoratoriumEvent build();
	
	RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder toBuilder();
	
	static RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder builder() {
		return new RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepudiationMoratoriumEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepudiationMoratoriumEvent> getType() {
		return RepudiationMoratoriumEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepudiationMoratoriumEventBuilder extends RepudiationMoratoriumEvent, CreditEvent.CreditEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder prune();
	}

	/*********************** Immutable Implementation of RepudiationMoratoriumEvent  ***********************/
	class RepudiationMoratoriumEventImpl extends CreditEvent.CreditEventImpl implements RepudiationMoratoriumEvent {
		
		protected RepudiationMoratoriumEventImpl(RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public RepudiationMoratoriumEvent build() {
			return this;
		}
		
		@Override
		public RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder toBuilder() {
			RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder builder) {
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
			return "RepudiationMoratoriumEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RepudiationMoratoriumEvent  ***********************/
	class RepudiationMoratoriumEventBuilderImpl extends CreditEvent.CreditEventBuilderImpl  implements RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder {
	
	
		public RepudiationMoratoriumEventBuilderImpl() {
		}
	
		
		@Override
		public RepudiationMoratoriumEvent build() {
			return new RepudiationMoratoriumEvent.RepudiationMoratoriumEventImpl(this);
		}
		
		@Override
		public RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder prune() {
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
		public RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder o = (RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder) other;
			
			
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
			return "RepudiationMoratoriumEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
