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
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder;
import fpml.confirmation.CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilderImpl;
import fpml.confirmation.CommodityPaymentDatesModel.CommodityPaymentDatesModelImpl;
import fpml.confirmation.CommodityRelativePaymentDates;
import fpml.confirmation.meta.CommodityPaymentDatesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Payment Date. This will consist of either a set of Payment Dates or else a Payment Date schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPaymentDatesModel", builder=CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilderImpl.class, version="${project.version}")
public interface CommodityPaymentDatesModel extends RosettaModelObject {

	CommodityPaymentDatesModelMeta metaData = new CommodityPaymentDatesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Payment Dates of the trade relative to the Calculation Periods.
	 */
	CommodityRelativePaymentDates getRelativePaymentDates();
	CommodityNonPeriodicPaymentDatesModel getCommodityNonPeriodicPaymentDatesModel();

	/*********************** Build Methods  ***********************/
	CommodityPaymentDatesModel build();
	
	CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder toBuilder();
	
	static CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder builder() {
		return new CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPaymentDatesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPaymentDatesModel> getType() {
		return CommodityPaymentDatesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("commodityNonPeriodicPaymentDatesModel"), processor, CommodityNonPeriodicPaymentDatesModel.class, getCommodityNonPeriodicPaymentDatesModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPaymentDatesModelBuilder extends CommodityPaymentDatesModel, RosettaModelObjectBuilder {
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates();
		CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder getOrCreateCommodityNonPeriodicPaymentDatesModel();
		CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder getCommodityNonPeriodicPaymentDatesModel();
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder setCommodityNonPeriodicPaymentDatesModel(CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("commodityNonPeriodicPaymentDatesModel"), processor, CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder.class, getCommodityNonPeriodicPaymentDatesModel());
		}
		

		CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPaymentDatesModel  ***********************/
	class CommodityPaymentDatesModelImpl implements CommodityPaymentDatesModel {
		private final CommodityRelativePaymentDates relativePaymentDates;
		private final CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel;
		
		protected CommodityPaymentDatesModelImpl(CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder builder) {
			this.relativePaymentDates = ofNullable(builder.getRelativePaymentDates()).map(f->f.build()).orElse(null);
			this.commodityNonPeriodicPaymentDatesModel = ofNullable(builder.getCommodityNonPeriodicPaymentDatesModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		@RosettaAttribute("commodityNonPeriodicPaymentDatesModel")
		public CommodityNonPeriodicPaymentDatesModel getCommodityNonPeriodicPaymentDatesModel() {
			return commodityNonPeriodicPaymentDatesModel;
		}
		
		@Override
		public CommodityPaymentDatesModel build() {
			return this;
		}
		
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder toBuilder() {
			CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder builder) {
			ofNullable(getRelativePaymentDates()).ifPresent(builder::setRelativePaymentDates);
			ofNullable(getCommodityNonPeriodicPaymentDatesModel()).ifPresent(builder::setCommodityNonPeriodicPaymentDatesModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPaymentDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(commodityNonPeriodicPaymentDatesModel, _that.getCommodityNonPeriodicPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (commodityNonPeriodicPaymentDatesModel != null ? commodityNonPeriodicPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPaymentDatesModel {" +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"commodityNonPeriodicPaymentDatesModel=" + this.commodityNonPeriodicPaymentDatesModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPaymentDatesModel  ***********************/
	class CommodityPaymentDatesModelBuilderImpl implements CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder {
	
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder relativePaymentDates;
		protected CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder commodityNonPeriodicPaymentDatesModel;
	
		public CommodityPaymentDatesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (relativePaymentDates!=null) {
				result = relativePaymentDates;
			}
			else {
				result = relativePaymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityNonPeriodicPaymentDatesModel")
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder getCommodityNonPeriodicPaymentDatesModel() {
			return commodityNonPeriodicPaymentDatesModel;
		}
		
		@Override
		public CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder getOrCreateCommodityNonPeriodicPaymentDatesModel() {
			CommodityNonPeriodicPaymentDatesModel.CommodityNonPeriodicPaymentDatesModelBuilder result;
			if (commodityNonPeriodicPaymentDatesModel!=null) {
				result = commodityNonPeriodicPaymentDatesModel;
			}
			else {
				result = commodityNonPeriodicPaymentDatesModel = CommodityNonPeriodicPaymentDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates) {
			this.relativePaymentDates = relativePaymentDates==null?null:relativePaymentDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityNonPeriodicPaymentDatesModel")
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder setCommodityNonPeriodicPaymentDatesModel(CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel) {
			this.commodityNonPeriodicPaymentDatesModel = commodityNonPeriodicPaymentDatesModel==null?null:commodityNonPeriodicPaymentDatesModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPaymentDatesModel build() {
			return new CommodityPaymentDatesModel.CommodityPaymentDatesModelImpl(this);
		}
		
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder prune() {
			if (relativePaymentDates!=null && !relativePaymentDates.prune().hasData()) relativePaymentDates = null;
			if (commodityNonPeriodicPaymentDatesModel!=null && !commodityNonPeriodicPaymentDatesModel.prune().hasData()) commodityNonPeriodicPaymentDatesModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelativePaymentDates()!=null && getRelativePaymentDates().hasData()) return true;
			if (getCommodityNonPeriodicPaymentDatesModel()!=null && getCommodityNonPeriodicPaymentDatesModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder o = (CommodityPaymentDatesModel.CommodityPaymentDatesModelBuilder) other;
			
			merger.mergeRosetta(getRelativePaymentDates(), o.getRelativePaymentDates(), this::setRelativePaymentDates);
			merger.mergeRosetta(getCommodityNonPeriodicPaymentDatesModel(), o.getCommodityNonPeriodicPaymentDatesModel(), this::setCommodityNonPeriodicPaymentDatesModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPaymentDatesModel _that = getType().cast(o);
		
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(commodityNonPeriodicPaymentDatesModel, _that.getCommodityNonPeriodicPaymentDatesModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (commodityNonPeriodicPaymentDatesModel != null ? commodityNonPeriodicPaymentDatesModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPaymentDatesModelBuilder {" +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"commodityNonPeriodicPaymentDatesModel=" + this.commodityNonPeriodicPaymentDatesModel +
			'}';
		}
	}
}
