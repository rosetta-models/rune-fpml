package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondEquityModel;
import fpml.confirmation.validation.BondEquityModelTypeFormatValidator;
import fpml.confirmation.validation.BondEquityModelValidator;
import fpml.confirmation.validation.exists.BondEquityModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BondEquityModel.class)
public class BondEquityModelMeta implements RosettaMetaData<BondEquityModel> {

	@Override
	public List<Validator<? super BondEquityModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.BondEquityModel>create(fpml.confirmation.validation.datarule.BondEquityModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BondEquityModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondEquityModel> validator() {
		return new BondEquityModelValidator();
	}

	@Override
	public Validator<? super BondEquityModel> typeFormatValidator() {
		return new BondEquityModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondEquityModel, Set<String>> onlyExistsValidator() {
		return new BondEquityModelOnlyExistsValidator();
	}
}
