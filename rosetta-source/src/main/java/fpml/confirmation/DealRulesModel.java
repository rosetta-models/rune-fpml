package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.DealRulesModel;
import fpml.confirmation.DealRulesModel.DealRulesModelBuilder;
import fpml.confirmation.DealRulesModel.DealRulesModelBuilderImpl;
import fpml.confirmation.DealRulesModel.DealRulesModelImpl;
import fpml.confirmation.ProRataFacilities;
import fpml.confirmation.TransferFeeDefinition;
import fpml.confirmation.meta.DealRulesModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * a model that defines deal-level rules.
 * @version ${project.version}
 */
@RosettaDataType(value="DealRulesModel", builder=DealRulesModel.DealRulesModelBuilderImpl.class, version="${project.version}")
public interface DealRulesModel extends RosettaModelObject {

	DealRulesModelMeta metaData = new DealRulesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The transfer fee amount and rules. This applies to the commitment transfer of any facility within the deal structure.
	 */
	TransferFeeDefinition getTransferFee();
	/**
	 * Groups of facilities which must be traded on a pro-rata basis. The ratio of facility trade amounts must be equal to the ratio of their corresponding global amounts.
	 */
	List<? extends ProRataFacilities> getProRataFacilities();

	/*********************** Build Methods  ***********************/
	DealRulesModel build();
	
	DealRulesModel.DealRulesModelBuilder toBuilder();
	
	static DealRulesModel.DealRulesModelBuilder builder() {
		return new DealRulesModel.DealRulesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealRulesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DealRulesModel> getType() {
		return DealRulesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transferFee"), processor, TransferFeeDefinition.class, getTransferFee());
		processRosetta(path.newSubPath("proRataFacilities"), processor, ProRataFacilities.class, getProRataFacilities());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealRulesModelBuilder extends DealRulesModel, RosettaModelObjectBuilder {
		TransferFeeDefinition.TransferFeeDefinitionBuilder getOrCreateTransferFee();
		TransferFeeDefinition.TransferFeeDefinitionBuilder getTransferFee();
		ProRataFacilities.ProRataFacilitiesBuilder getOrCreateProRataFacilities(int _index);
		List<? extends ProRataFacilities.ProRataFacilitiesBuilder> getProRataFacilities();
		DealRulesModel.DealRulesModelBuilder setTransferFee(TransferFeeDefinition transferFee);
		DealRulesModel.DealRulesModelBuilder addProRataFacilities(ProRataFacilities proRataFacilities0);
		DealRulesModel.DealRulesModelBuilder addProRataFacilities(ProRataFacilities proRataFacilities1, int _idx);
		DealRulesModel.DealRulesModelBuilder addProRataFacilities(List<? extends ProRataFacilities> proRataFacilities2);
		DealRulesModel.DealRulesModelBuilder setProRataFacilities(List<? extends ProRataFacilities> proRataFacilities3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transferFee"), processor, TransferFeeDefinition.TransferFeeDefinitionBuilder.class, getTransferFee());
			processRosetta(path.newSubPath("proRataFacilities"), processor, ProRataFacilities.ProRataFacilitiesBuilder.class, getProRataFacilities());
		}
		

		DealRulesModel.DealRulesModelBuilder prune();
	}

	/*********************** Immutable Implementation of DealRulesModel  ***********************/
	class DealRulesModelImpl implements DealRulesModel {
		private final TransferFeeDefinition transferFee;
		private final List<? extends ProRataFacilities> proRataFacilities;
		
		protected DealRulesModelImpl(DealRulesModel.DealRulesModelBuilder builder) {
			this.transferFee = ofNullable(builder.getTransferFee()).map(f->f.build()).orElse(null);
			this.proRataFacilities = ofNullable(builder.getProRataFacilities()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("transferFee")
		public TransferFeeDefinition getTransferFee() {
			return transferFee;
		}
		
		@Override
		@RosettaAttribute("proRataFacilities")
		public List<? extends ProRataFacilities> getProRataFacilities() {
			return proRataFacilities;
		}
		
		@Override
		public DealRulesModel build() {
			return this;
		}
		
		@Override
		public DealRulesModel.DealRulesModelBuilder toBuilder() {
			DealRulesModel.DealRulesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealRulesModel.DealRulesModelBuilder builder) {
			ofNullable(getTransferFee()).ifPresent(builder::setTransferFee);
			ofNullable(getProRataFacilities()).ifPresent(builder::setProRataFacilities);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealRulesModel _that = getType().cast(o);
		
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!ListEquals.listEquals(proRataFacilities, _that.getProRataFacilities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (proRataFacilities != null ? proRataFacilities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealRulesModel {" +
				"transferFee=" + this.transferFee + ", " +
				"proRataFacilities=" + this.proRataFacilities +
			'}';
		}
	}

	/*********************** Builder Implementation of DealRulesModel  ***********************/
	class DealRulesModelBuilderImpl implements DealRulesModel.DealRulesModelBuilder {
	
		protected TransferFeeDefinition.TransferFeeDefinitionBuilder transferFee;
		protected List<ProRataFacilities.ProRataFacilitiesBuilder> proRataFacilities = new ArrayList<>();
	
		public DealRulesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transferFee")
		public TransferFeeDefinition.TransferFeeDefinitionBuilder getTransferFee() {
			return transferFee;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder getOrCreateTransferFee() {
			TransferFeeDefinition.TransferFeeDefinitionBuilder result;
			if (transferFee!=null) {
				result = transferFee;
			}
			else {
				result = transferFee = TransferFeeDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proRataFacilities")
		public List<? extends ProRataFacilities.ProRataFacilitiesBuilder> getProRataFacilities() {
			return proRataFacilities;
		}
		
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder getOrCreateProRataFacilities(int _index) {
		
			if (proRataFacilities==null) {
				this.proRataFacilities = new ArrayList<>();
			}
			ProRataFacilities.ProRataFacilitiesBuilder result;
			return getIndex(proRataFacilities, _index, () -> {
						ProRataFacilities.ProRataFacilitiesBuilder newProRataFacilities = ProRataFacilities.builder();
						return newProRataFacilities;
					});
		}
		
		@Override
		@RosettaAttribute("transferFee")
		public DealRulesModel.DealRulesModelBuilder setTransferFee(TransferFeeDefinition transferFee) {
			this.transferFee = transferFee==null?null:transferFee.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("proRataFacilities")
		public DealRulesModel.DealRulesModelBuilder addProRataFacilities(ProRataFacilities proRataFacilities) {
			if (proRataFacilities!=null) this.proRataFacilities.add(proRataFacilities.toBuilder());
			return this;
		}
		
		@Override
		public DealRulesModel.DealRulesModelBuilder addProRataFacilities(ProRataFacilities proRataFacilities, int _idx) {
			getIndex(this.proRataFacilities, _idx, () -> proRataFacilities.toBuilder());
			return this;
		}
		@Override 
		public DealRulesModel.DealRulesModelBuilder addProRataFacilities(List<? extends ProRataFacilities> proRataFacilitiess) {
			if (proRataFacilitiess != null) {
				for (ProRataFacilities toAdd : proRataFacilitiess) {
					this.proRataFacilities.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DealRulesModel.DealRulesModelBuilder setProRataFacilities(List<? extends ProRataFacilities> proRataFacilitiess) {
			if (proRataFacilitiess == null)  {
				this.proRataFacilities = new ArrayList<>();
			}
			else {
				this.proRataFacilities = proRataFacilitiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DealRulesModel build() {
			return new DealRulesModel.DealRulesModelImpl(this);
		}
		
		@Override
		public DealRulesModel.DealRulesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealRulesModel.DealRulesModelBuilder prune() {
			if (transferFee!=null && !transferFee.prune().hasData()) transferFee = null;
			proRataFacilities = proRataFacilities.stream().filter(b->b!=null).<ProRataFacilities.ProRataFacilitiesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransferFee()!=null && getTransferFee().hasData()) return true;
			if (getProRataFacilities()!=null && getProRataFacilities().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealRulesModel.DealRulesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DealRulesModel.DealRulesModelBuilder o = (DealRulesModel.DealRulesModelBuilder) other;
			
			merger.mergeRosetta(getTransferFee(), o.getTransferFee(), this::setTransferFee);
			merger.mergeRosetta(getProRataFacilities(), o.getProRataFacilities(), this::getOrCreateProRataFacilities);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DealRulesModel _that = getType().cast(o);
		
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!ListEquals.listEquals(proRataFacilities, _that.getProRataFacilities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (proRataFacilities != null ? proRataFacilities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealRulesModelBuilder {" +
				"transferFee=" + this.transferFee + ", " +
				"proRataFacilities=" + this.proRataFacilities +
			'}';
		}
	}
}
