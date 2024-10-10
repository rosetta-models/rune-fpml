package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.RepudiationMoratorium;
import fpml.confirmation.RepudiationMoratorium.RepudiationMoratoriumBuilder;
import fpml.confirmation.RepudiationMoratorium.RepudiationMoratoriumBuilderImpl;
import fpml.confirmation.RepudiationMoratorium.RepudiationMoratoriumImpl;
import fpml.confirmation.RepudiationMoratoriumEvent;
import fpml.confirmation.RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder;
import fpml.confirmation.RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilderImpl;
import fpml.confirmation.RepudiationMoratoriumEvent.RepudiationMoratoriumEventImpl;
import fpml.confirmation.meta.RepudiationMoratoriumMeta;


/**
 * @version ${project.version}
 */
@RosettaDataType(value="RepudiationMoratorium", builder=RepudiationMoratorium.RepudiationMoratoriumBuilderImpl.class, version="${project.version}")
public interface RepudiationMoratorium extends RepudiationMoratoriumEvent {

	RepudiationMoratoriumMeta metaData = new RepudiationMoratoriumMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RepudiationMoratorium build();
	
	RepudiationMoratorium.RepudiationMoratoriumBuilder toBuilder();
	
	static RepudiationMoratorium.RepudiationMoratoriumBuilder builder() {
		return new RepudiationMoratorium.RepudiationMoratoriumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RepudiationMoratorium> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RepudiationMoratorium> getType() {
		return RepudiationMoratorium.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
	}
	

	/*********************** Builder Interface  ***********************/
	interface RepudiationMoratoriumBuilder extends RepudiationMoratorium, RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilder {

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
		}
		

		RepudiationMoratorium.RepudiationMoratoriumBuilder prune();
	}

	/*********************** Immutable Implementation of RepudiationMoratorium  ***********************/
	class RepudiationMoratoriumImpl extends RepudiationMoratoriumEvent.RepudiationMoratoriumEventImpl implements RepudiationMoratorium {
		
		protected RepudiationMoratoriumImpl(RepudiationMoratorium.RepudiationMoratoriumBuilder builder) {
			super(builder);
		}
		
		@Override
		public RepudiationMoratorium build() {
			return this;
		}
		
		@Override
		public RepudiationMoratorium.RepudiationMoratoriumBuilder toBuilder() {
			RepudiationMoratorium.RepudiationMoratoriumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RepudiationMoratorium.RepudiationMoratoriumBuilder builder) {
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
			return "RepudiationMoratorium {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RepudiationMoratorium  ***********************/
	class RepudiationMoratoriumBuilderImpl extends RepudiationMoratoriumEvent.RepudiationMoratoriumEventBuilderImpl  implements RepudiationMoratorium.RepudiationMoratoriumBuilder {
	
	
		public RepudiationMoratoriumBuilderImpl() {
		}
	
		
		@Override
		public RepudiationMoratorium build() {
			return new RepudiationMoratorium.RepudiationMoratoriumImpl(this);
		}
		
		@Override
		public RepudiationMoratorium.RepudiationMoratoriumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RepudiationMoratorium.RepudiationMoratoriumBuilder prune() {
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
		public RepudiationMoratorium.RepudiationMoratoriumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RepudiationMoratorium.RepudiationMoratoriumBuilder o = (RepudiationMoratorium.RepudiationMoratoriumBuilder) other;
			
			
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
			return "RepudiationMoratoriumBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
